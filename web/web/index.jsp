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
        var gridColumns, productStore, grid, background;
        gridColumns = [
            {
                header: 'Id',
                flex: 1,
                dataIndex: 'id',
                sortable: false,
                hidden: true
            },
            {
                header: 'Nume produs',
                flex: 1,
                dataIndex: 'productName',
                sortable: false
            },
            {
                header: 'Categorie',
                flex: 1,
                dataIndex: 'category.categoryName',
                sortable: false
            },
            {
                header: 'Marca',
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
            columns: gridColumns,
            title: 'Lista produse'
        });

        background = new Ext.panel.Panel({
            minHeight: 1000,
            renderTo: Ext.getBody(),
            bodyStyle: {
                backgroundColor: "gray"
            },
            items: [
                grid
            ]
        });

    });
</script>
<%--<div id="listGrid" style="margin: 20px"></div>--%>