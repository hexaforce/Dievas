'use strict';
/*******************************************************************************
 * AcceptanceReportController
 ******************************************************************************/
app.controller('AcceptanceReportController', ['AcceptanceReportService', '$scope', function (AcceptanceReportService, $scope) {
  
  $scope.init = function () {
    console.log('AcceptanceReportController.js: init()');
    AcceptanceReportService.init();
    $scope.serviceName = AcceptanceReportService.getInitResult()[0].message;
  }
  
}]);