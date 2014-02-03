 /**
 * Created by bogdan on 2/2/14.
 */
Ext.define('Ext.gameon.model.Product', {
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


 Ext.define('Ext.gameon.model.ProductStore', {
    extend: 'Ext.gameon.common.GenericStore',
    model: 'Ext.gameon.model.Product',
    constructor: function (config) {
        this.callParent([config]);
        return this;
    }
});