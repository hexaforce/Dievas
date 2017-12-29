'use strict';
/*******************************************************************************
 * DailyScheduleController
 ******************************************************************************/
app.controller('DailyScheduleController', ['DailyScheduleService', '$scope', function (DailyScheduleService, $scope) {
  
  $scope.init = function () {
    console.log('Controller(js): init()');
    DailyScheduleService.init();
    $scope.serviceName = DailyScheduleService.getStorageData();
  }
  
}]);