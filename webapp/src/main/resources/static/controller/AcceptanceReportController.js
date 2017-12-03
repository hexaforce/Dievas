'use strict';
/*******************************************************************************
 * AcceptanceReportController
 ******************************************************************************/
app.controller('AcceptanceReportController', ['AcceptanceReportService', '$scope', function (AcceptanceReportService, $scope) {
  
  $scope.init = function () {
    console.log('Controller(js): init()');
    AcceptanceReportService.init();
    $scope.serviceName = AcceptanceReportService.getStorageData();
  }
  
}]);