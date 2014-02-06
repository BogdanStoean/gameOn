<%--
  User: bogdan
  Date: 2/5/14
  Time: 8:12 PM
--%>
<%@ include file="/jsp/common/init.jsp" %>
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
                },
                new Ext.form.Panel({
                    title: 'Sign in',
                    bodyPadding: 1,
                    url: '/login',
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
                            formBind: true, //only enabled once the form is valid
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
                            text: 'Sign up',
                            handler: function () {
                                window.location = appPath + '/createAccount';
                            }
                        }
                    ]
                })
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