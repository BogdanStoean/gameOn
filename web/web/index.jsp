<%--
  User: bogdan
  Date: 1/24/14
  Time: 10:30 AM
--%>
<%@ include file="/jsp/common/include.jsp" %>
<jsp:include page="/jsp/common/init.jsp"/>
<script type="text/javascript">

Ext.define('Product', {
    extend: 'Ext.data.Model',
    fields: [
        'id',
        'productCode',
        'pictureLink',
        'productName',
        'description',
        'category.categoryName',
        'brand.brandName'
    ],
    idProperty: 'id'
});

Ext.onReady(function () {
    var gridColumns, productStore, grid, background, menu, banner;
    gridColumns = [
        {
            dataIndex: 'pictureLink',
            sortable: false,
            align: 'center',
            flex: 0.5,
            renderer: function (value) {
                return '<div><img src="' + value + '"></div>';
            }
        },
        {
            header: 'Id',
            flex: 1,
            dataIndex: 'id',
            sortable: false,
            hidden: true
        },
        {
            header: 'Name',
            flex: 1,
            dataIndex: 'productName',
            align: 'center',
            sortable: false
        },
        {
            header: 'Category',
            flex: 1,
            dataIndex: 'category.categoryName',
            align: 'center',
            sortable: false
        },
        {
            header: 'Publisher',
            flex: 1,
            dataIndex: 'brand.brandName',
            align: 'center',
            sortable: false
        },
        {
            xtype: 'actioncolumn',
            header: 'Product details',
            align: 'center',
            flex: 0.5,
            items: [
                {
                    icon: 'images/icons/fam/book.png',
                    handler: function (grid, rowIndex, colIndex) {
                        var rec = grid.getStore().getAt(rowIndex);
                        window.location = appPath + '/getPage?productId=' + rec.get('id');
                    }
                }
            ]
        }
        <c:if test="${not empty loggedUser and loggedUser.userBean.role eq 'ADMIN'}">
        ,
        {
            xtype: 'actioncolumn',
            header: 'Edit',
            align: 'center',
            flex: 0.5,
            items: [
                {
                    icon: 'images/icons/silk/application_edit.png',
                    handler: function (grid, rowIndex, colIndex) {
                        var rec = grid.getStore().getAt(rowIndex);
                        window.location = appPath + '/addProduct?productId=' + rec.get('id');
                    }
                }
            ]
        }

        </c:if>
        <c:if test="${not empty loggedUser and loggedUser.userBean.role eq 'USER'}">
        ,
        {
            xtype: 'actioncolumn',
            header: 'Add to cart',
            align: 'center',
            flex: 0.5,
            items: [
                {
                    icon: 'images/icons/silk/cart_add.png',
                    handler: function (grid, rowIndex, colIndex) {
                        var rec = grid.getStore().getAt(rowIndex);
                        //noinspection JSValidateTypes
                        Ext.Ajax.request({
                            url: appPath + '/addToCart.json',
                            method: "GET",
                            params: {
                                productId: rec.get('id')
                            },
                            success: function (response, opts) {
                                window.location = appPath;
                            },
                            failure: function (response, opts) //noinspection JSValidateTypes
                            {

                            }
                        });
                    }
                }
            ]
        }
        </c:if>
    ];


    productStore = Ext.create('Ext.data.Store', {
        model: 'Product',
        proxy: {
            type: 'ajax',
            url: appPath + '/products/list.json',
            reader: {
                type: 'json',
                totalProperty: 'totalRecords',
                idProperty: 'id',
                root: 'records'
            },
            writer: {
                type: 'json',
                encode: true
            }
        },
        autoLoad: true
    });


    grid = new Ext.grid.GridPanel({
        store: productStore,
        columns: gridColumns,
        minHeight: 400,
        maxHeight: 500,
        dockedItems: [
            {
                xtype: 'pagingtoolbar',
                store: productStore,
                dock: 'bottom',
                displayInfo: true
            }
            <c:if test="${not empty loggedUser and loggedUser.userBean.role eq 'ADMIN'}">
            ,
            {
                xtype: 'toolbar',
                dock: 'top',
                items: [
                    {
                        xtype: 'button',
                        text: 'Add product',
                        handler: function () {
                            window.location = appPath + '/addProduct?productId=0';
                        }
                    }
                ]
            }

            </c:if>

        ]
    });

    menu = new Ext.tab.Panel({
        items: [
            {
                title: 'All games',
                flex: 1
            }
            <c:if test="${not empty loggedUser and loggedUser.userBean.role eq 'USER'}">
            ,
            {
                title: 'My games',
                flex: 1
            }
            </c:if>
        ],
        listeners: {
            tabchange: function (tabPanel, newCard, oldCard, eOpts) {

                if (newCard.title == 'All games') {
                    productStore.load({
                        params: {
                            start: 0,
                            limit: 25,
                            tabId: 0
                        }
                    });
                } else {
                    productStore.load({
                        params: {
                            start: 0,
                            limit: 25,
                            tabId: 1,
                            userId: '${loggedUser.userBean.userId}'
                        }
                    });
                }
            }
        }
    });

    banner = new Ext.panel.Panel({
        minHeight: 100,
        layout: 'column',
        items: [
            {
                columnWidth: 0.80
            }

            <c:choose>
            <c:when test="${not empty loggedUser}">
            ,
            new Ext.form.Panel({
                title: 'User information',
                bodyPadding: 1,
                url: appPath + '/logout',
                items: [
                    {
                        xtype: 'displayfield',
                        fieldLabel: 'Welcome',
                        value: '${loggedUser.userBean.username}'
                    }
                    <c:if test="${not empty loggedUser and loggedUser.userBean.role eq 'USER'}">
                    ,
                    {
                        xtype: 'toolbar',
                        items: [
                            {
                                xtype: 'button',
                                text: 'CART(${loggedUser.shoppingCartSize})',
                                handler: function () {
                                    window.location = appPath + '/createOrder';
                                }
                            }
                        ]
                    }

                    </c:if>
                ],
                buttons: [
                    {
                        text: 'Sign out',
                        handler: function () {
                            var form = this.up('form').getForm();
                            if (form.isValid()) {
                                form.submit({
                                    success: function (form, action) {
                                        window.location = appPath + '/index';
                                    },
                                    failure: function (form, action) {

                                    }
                                });
                            }
                        }

                    }
                ]
            })
            </c:when>
            <c:otherwise>
            ,
            new Ext.form.Panel({
                title: 'Sign in',
                bodyPadding: 1,
                url: appPath + '/authentication',
                defaultType: 'textfield',
                items: [
                    {
                        fieldLabel: 'Username',
                        name: 'username',
                        allowBlank: false
                    },
                    {
                        fieldLabel: 'Password',
                        inputType: 'password',
                        name: 'password'

                    }
                ],

                buttons: [
                    {
                        text: 'Sign in',
                        formBind: true,
                        disabled: true,
                        handler: function () {
                            var form = this.up('form').getForm();
                            if (form.isValid()) {
                                form.submit({
                                    success: function (form, action) {
                                        window.location = appPath + '/index';
                                    },
                                    failure: function (form, action) {

                                    }
                                });
                            }
                        }
                    },
                    {
                        text: 'Sign up',
                        handler: function () {
                            window.location = appPath + '/createAccount';
                        }
                    }
                ]
            })
            </c:otherwise>
            </c:choose>
        ]
    });

    background = new Ext.panel.Panel({
        minHeight: 1000,
        renderTo: Ext.getBody(),
        bodyStyle: {
            backgroundColor: "gray"
        },
        layout: {
            type: 'vbox',
            align: 'stretch',
            padding: 10
        },
        items: [
            banner,
            menu,
            grid
        ]
    });

})
;
</script>
