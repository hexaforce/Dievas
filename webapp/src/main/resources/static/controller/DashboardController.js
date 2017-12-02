'use strict';
/*******************************************************************************
 * Dashboard angular controller
 ******************************************************************************/
app.controller('DashboardController', ['DashboardService', '$scope', function (DashboardService, $scope) {
  
  $scope.init = function () {
    console.log('Controller(js): init()');
    DashboardService.init();
    $scope.serviceName = DashboardService.getLocalData()[0].message;
  }
  
  $scope.DefaultAction = function () {
    console.log('DefaultAction');
    DashboardService.callJavaController();
  }
  
  $scope.PrimaryAction = function () {
    console.log('PrimaryAction');
    DashboardService.callSpringDataREST();
  }
  
  $scope.SuccessAction = function () {
    console.log('SuccessAction');
    DashboardService.callBatchJob();
  }
  
  $scope.InfoAction = function () {
    console.log('InfoAction');
  }
  $scope.WarningAction = function () {
    console.log('WarningAction');
  }
  $scope.DangerAction = function () {
    console.log('DangerAction');
  }
  $scope.DarkAction = function () {
    console.log('DarkAction');
  }
  $scope.LinkAction = function () {
    console.log('LinkAction');
  }
  
}]);