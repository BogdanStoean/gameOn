<%--
  Created by IntelliJ IDEA.
  User: bogdan
  Date: 2/8/14
  Time: 11:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/jsp/common/include.jsp" %>
<jsp:include page="/jsp/common/init.jsp"/>
<c:set var="product" value="${sessionScope.product}"/>
<c:set var="productId" value="${sessionScope.productId}"/>
<script type="text/javascript">

Ext.define('Brand', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'id', type: 'int'},
        'brandCode',
        'brandName'
    ],
    idProperty: 'id'
});

Ext.define('Category', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'id', type: 'int'},
        'categoryCode',
        'categoryName'
    ],
    idProperty: 'id'
});


Ext.onReady(function () {
    var background, banner, productFormPanel, brandStore, categoryStore;


    brandStore = Ext.create('Ext.data.Store', {
        model: 'Brand',
        proxy: {
            type: 'ajax',
            url: appPath + '/brands/list.json',
            reader: {
                type: 'json',
                idProperty: 'id'
            },
            writer: {
                type: 'json',
                encode: true
            }
        },
        autoLoad: true
    });

    categoryStore = Ext.create('Ext.data.Store', {
        model: 'Category',
        proxy: {
            type: 'ajax',
            url: appPath + '/categories/list.json',
            reader: {
                type: 'json',
                idProperty: 'id'
            },
            writer: {
                type: 'json',
                encode: true
            }
        },
        autoLoad: true
    });


    banner = new Ext.panel.Panel({
        minHeight: 100,
        layout: 'column',
        items: [
            {
                columnWidth: 0.90
            }
            <c:choose>
            <c:when test = "${not empty loggedUser}">
            ,
            new Ext.form.Panel({
                title: 'User information',
                minWidth: 200,
                bodyPadding: 1,
                url: appPath + '/logout',
                items: [
                    {
                        xtype: 'displayfield',
                        fieldLabel: 'Welcome',
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

    productFormPanel = new Ext.form.Panel({
        title: 'Add product',
        minHeight: 500,
        layout: {
            type: 'vbox',
            align: 'left',
            padding: 10
        },
        defaults: {
            minWidth: 1000
        },
        items: [
            {
                xtype: 'numberfield',
                hidden: true,
                name: 'id',
                value:${productId}

            },
            {
                xtype: 'textfield',
                fieldLabel: 'Product name',
                value: '${product.productName}',
                name: 'productName',
                allowBlank: false
            },
            {

                xtype: 'textfield',
                fieldLabel: 'Price',
                name: 'price',
                value: Ext.util.Format.number('${product.price}', '0.00'),
                allowBlank: false
            },
            {
                xtype: 'combobox',
                fieldLabel: 'Category',
                store: categoryStore,
                queryMode: 'local',
                displayField: 'categoryName',
                name: 'categoryId',
                editable: false,
                valueField: 'id',
                value: Ext.util.Format.number('${product.category.id}', '0'),
                allowBlank: false
            },
            {
                xtype: 'combobox',
                fieldLabel: 'Brand',
                store: brandStore,
                editable: false,
                queryMode: 'local',
                displayField: 'brandName',
                name: 'brandId',
                valueField: 'id',
                value: Ext.util.Format.number('${product.brand.id}', '0'),
                allowBlank: false
            },
            {
                xtype: 'textfield',
                fieldLabel: 'Banner details picture',
                name: 'bannerLink',
                value: '${product.bannerLink}'
            },
            {
                xtype: 'textfield',
                fieldLabel: 'Banner grid picture',
                name: 'pictureLink',
                value: '${product.pictureLink}'
            },
            {
                xtype: 'textareafield',
                fieldLabel: 'Description',
                name: 'description',
                value: '${product.description}'
            },
            {
                xtype: 'toolbar',
                layout: 'column',
                items: [
                    {
                        xtype: 'tbseparator',
                        columnWidth: 0.4
                    },
                    {
                        text: 'Cancel',
                        columnWidth: 0.1,
                        handler: function () {
                            window.location = appPath;
                        }
                    },
                    {
                        text: 'Save',
                        columnWidth: 0.1,
                        formBind: true,
                        disabled: true,
                        jsonSubmit: true,
                        handler: function () {
                            var form = this.up('form').getForm();
                            if (form.isValid()) {

                                //noinspection JSValidateTypes
                                Ext.Ajax.request({
                                    url: appPath + '/rest/product/saveProduct.json',
                                    method: "POST",
                                    headers: { 'Content-Type': 'application/json' },
                                    jsonData: Ext.encode(form.getValues()),
                                    success: function (response, opts) {
                                        window.location = appPath;
                                    },
                                    failure: function (response, opts) {

                                    }
                                });
                            }
                        }
                    },
                    {
                        xtype: 'tbseparator',
                        columnWidth: 0.4
                    }
                ]
            }
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
            banner, productFormPanel
        ]
    });

})
;
</script>