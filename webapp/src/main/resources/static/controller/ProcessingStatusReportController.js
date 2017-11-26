'use strict';
/*******************************************************************************
 * ProcessingStatusReportController
 ******************************************************************************/
app.controller('ProcessingStatusReportController', ['ProcessingStatusReportService', '$scope', function (ProcessingStatusReportService, $scope) {
  
  $scope.init = function () {
    console.log('ProcessingStatusReportController.js: init()');
    ProcessingStatusReportService.init();
    $scope.serviceName = ProcessingStatusReportService.getInitResult()[0].message;
  }
  
}]);