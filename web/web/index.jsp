<%--
  User: bogdan
  Date: 1/24/14
  Time: 10:30 AM
--%>
<%@ include file="WEB-INF/jsp/common/init.jsp" %>
<script type="text/javascript">
    Ext.require(['Ext.gameon.Product']);
    Ext.onReady(function () {
        var gridColumns, productStore, grid;

        gridColumns = [
            {
                header: 'Id',
                width: 100,
                dataIndex: 'id',
                sortable: false,
                hidden: true
            },
            {
                header: 'Nume produs',
                width: 300,
                dataIndex: 'productName',
                sortable: false
            },
            {
                header: 'Categorie',
                width: 400,
                dataIndex: 'category.categoryName',
                sortable: false
            },
            {
                header: 'Marca',
                width: 400,
                dataIndex: 'brand.brandName',
                sortable: false
            }
        ];


        productStore = Ext.create('Ext.gameon.model.ProductStore', {
            url: '/web/products'
        });


        grid = new Ext.grid.GridPanel({
            store: productStore,
            renderTo: 'listGrid',
            columns: gridColumns,
            height: 200,
            width: 1000,
            title: 'Lista produse'
        });
    });
</script>
<div id="listGrid" style="margin: 20px"></div>