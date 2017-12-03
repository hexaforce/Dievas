'use strict';
/*******************************************************************************
 * DashboardController
 ******************************************************************************/
app.controller('DashboardController', ['DashboardService', '$scope', function (DashboardService, $scope) {
  
  $scope.init = function () {
    console.log('Controller(js): init()');
    DashboardService.init();
    $scope.serviceName = DashboardService.getStorageData();
  }
  
}]);