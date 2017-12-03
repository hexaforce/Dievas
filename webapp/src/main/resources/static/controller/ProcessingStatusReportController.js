'use strict';
/*******************************************************************************
 * ProcessingStatusReportController
 ******************************************************************************/
app.controller('ProcessingStatusReportController', ['ProcessingStatusReportService', '$scope', function (ProcessingStatusReportService, $scope) {
  
  $scope.init = function () {
    console.log('Controller(js): init()');
    ProcessingStatusReportService.init();
    $scope.serviceName = ProcessingStatusReportService.getStorageData();
  }
  
}]);