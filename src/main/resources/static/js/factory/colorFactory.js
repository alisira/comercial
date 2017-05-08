/**
 * Factory Color
 * @extends activeRecordService
 * @param {activeRecordService} activeRecordService
 * @return {activeRecordService} activeRecordService overwrited to controller
 */
App.factory('Color', function(activeRecordService) {

    function Color(){
        this.model = 'color';
    }

    Color.prototype = activeRecordService;

    return Color;
});
