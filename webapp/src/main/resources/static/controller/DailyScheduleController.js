'use strict';
/*******************************************************************************
 * DailyScheduleController
 ******************************************************************************/
app.controller('DailyScheduleController', ['DailyScheduleService', '$scope', function (DailyScheduleService, $scope) {
  
  $scope.init = function () {
    console.log('DailyScheduleController.js: init()');
    DailyScheduleService.init();
    $scope.serviceName = DailyScheduleService.getInitResult()[0].message;
  }
  
}]);