<%--
  User: bogdan
  Date: 2/5/14
  Time: 8:12 PM
--%>
<%@ include file="/jsp/common/include.jsp" %>
<jsp:include page="/jsp/common/init.jsp"/>
<script type="text/javascript">

    Ext.onReady(function () {
        var background, menu, banner;

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
                menu
            ]
        });

    })
    ;
</script>