/**
 * Factory Status
 * @extends activeRecordService
 * @param {activeRecordService} activeRecordService
 * @return {activeRecordService} activeRecordService overwrited to controller
 */
App.factory('Status', function(activeRecordService) {

    function Status(){
        this.model = 'status';
    }

    Status.prototype = activeRecordService;

    return Status;
});
