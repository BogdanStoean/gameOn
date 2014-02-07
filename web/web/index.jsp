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
                    handler: function () {
                        window.location = appPath + '/getPage';
                    }
                }
            ]
        }
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
        ]
    });

    menu = new Ext.tab.Panel({
        items: [
            {
                title: 'All games',
                flex: 1
            },
            {
                title: 'Favorite games',
                flex: 1
            }
        ]
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
                        fieldLabel: 'Logged user',
                        value: '${loggedUser.userBean.username}'
                    }
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
