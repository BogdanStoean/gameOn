<%--
  User: bogdan
  Date: 1/24/14
  Time: 10:30 AM
--%>
<%@ include file="WEB-INF/jsp/common/init.jsp" %>
<script type="text/javascript">

    Ext.define('Product', {
        extend: 'Ext.data.Model',
        fields: [
            'id',
            'productCode',
            'productName',
            'description',
            'category.categoryName',
            'brand.brandName'
        ],
        idProperty: 'id'
    });

    Ext.onReady(function () {
        var gridColumns, productStore, grid, background, menu, banner, slideShow;
        gridColumns = [
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
                sortable: false
            },
            {
                header: 'Category',
                flex: 1,
                dataIndex: 'category.categoryName',
                sortable: false
            },
            {
                header: 'Publisher',
                flex: 1,
                dataIndex: 'brand.brandName',
                sortable: false
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
            columns: gridColumns
        });

        menu = new Ext.tab.Panel({
            items: [
                {
                    title: 'All games',
                    flex: 1
                },
                {
                    title: 'Favorites games',
                    flex: 1
                }
            ]
        });


        banner = new Ext.panel.Panel({
            minHeight: 100
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
                menu,
                banner,
                grid
            ]
        });

    });
</script>