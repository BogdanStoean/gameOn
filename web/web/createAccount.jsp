<%--
  User: bogdan
  Date: 2/6/14
  Time: 10:22 AM
--%>
<%@ include file="/jsp/common/include.jsp" %>
<jsp:include page="/jsp/common/init.jsp"/>
<script type="text/javascript">

    Ext.onReady(function () {
        var background, banner, formPanel;


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

        formPanel = new Ext.panel.Panel({
            minHeight: 100,
            layout: 'column',
            items: [
                {
                    columnWidth: 0.40
                },
                new Ext.form.Panel({
                    title: 'Create account',
                    bodyPadding: 1,
                    minWidth: 500,
                    url: '/saveAccount.json',
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
                            name: 'password',
                            allowBlank: false

                        },
                        {
                            fieldLabel: 'First name',
                            name: 'firstName'
                        },
                        {
                            fieldLabel: 'Last name',
                            name: 'lastName'
                        }


                    ],

                    buttons: [
                        {
                            text: 'Save',
                            formBind: true,
                            disabled: true,
                            handler: function () {
                                var form = this.up('form').getForm();
                                if (form.isValid()) {
                                    form.submit({
                                        success: function (form, action) {

                                        },
                                        failure: function (form, action) {

                                        }
                                    });
                                }
                            }
                        },
                        {
                            text: 'Cancel',
                            handler: function () {
                                window.location = appPath;
                            }
                        }
                    ]
                }),
                {
                    columnWidth: 0.20
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
                banner,
                formPanel
            ]
        });

    })
    ;
</script>