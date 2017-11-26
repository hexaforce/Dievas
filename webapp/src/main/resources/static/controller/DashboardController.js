'use strict';
/*******************************************************************************
 * DashboardController
 ******************************************************************************/
app.controller('DashboardController', ['DashboardService', '$scope', function (DashboardService, $scope) {
  
  $scope.init = function () {
    console.log('DashboardController.js: init()');
    DashboardService.init();
    $scope.serviceName = DashboardService.getInitResult()[0].message;
  }
  
}]);