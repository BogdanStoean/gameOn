/**
 * Created by bogdan on 2/2/14.
 */
Ext.define('Ext.esolutions.common.GenericStore', {
    extend: 'Ext.data.Store',
    autoLoad: true,
    pageSize: 20,
    remoteFilter: false,
    remoteGroup: false,
    remoteSort: false,
    constructor: function (config) {
        config.proxy = {
            type: 'ajax',
            url: config.url,
            extraParams: config.extraParams,
            reader: {
                type: 'json',
                totalProperty: 'totalRecords',
                idProperty: config.idProperty != null ? config.idProperty : 'id',
                root: 'records'
            },
            writer: {
                type: 'json',
                encode: true
            }
        };
        this.callParent([config]);
        return this;
    }
});