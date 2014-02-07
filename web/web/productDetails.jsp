<%--
  User: bogdan
  Date: 2/5/14
  Time: 8:12 PM
--%>
<%@ include file="/jsp/common/include.jsp" %>
<jsp:include page="/jsp/common/init.jsp"/>
<c:set var="product" value="${sessionScope.product}"/>
<script type="text/javascript">

    Ext.onReady(function () {
        var background, banner, productDetailsPanel;

        banner = new Ext.panel.Panel({
            minHeight: 100,
            layout: 'column',
            items: [
                {
                    columnWidth: 0.80
                }
                <c:choose>
                <c:when test = "${not empty loggedUser}">
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

        productDetailsPanel = new Ext.form.Panel({
            title: 'Product details',
            items: [
                {
                    xtype: 'displayfield',
                    fieldLabel: 'Product name',
                    value: '${product.productName}'
                },
                {

                    xtype: 'displayfield',
                    fieldLabel: 'Price',
                    value: '${product.price}'
                },
                {
                    xtype: 'displayfield',
                    fieldLabel: 'Category',
                    value: '${product.category.categoryName}'
                },
                {
                    xtype: 'displayfield',
                    fieldLabel: 'Brand',
                    value: '${product.brand.brandName}'
                },
                {
                    xtype: 'image',
                    src: '${product.bannerLink}'
                },
                {
                    xtype: 'displayfield'
                    fieldLabel: 'Description',
                    value: '${product.description}'
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
                banner, productDetailsPanel
            ]
        });

    })
    ;
</script>