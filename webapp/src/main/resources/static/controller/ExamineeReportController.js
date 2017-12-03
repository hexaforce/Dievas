'use strict';
/*******************************************************************************
 * ExamineeReportController
 ******************************************************************************/
app.controller('ExamineeReportController', ['ExamineeReportService', '$scope', function (ExamineeReportService, $scope) {
  
  $scope.init = function () {
    console.log('Controller(js): init()');
    ExamineeReportService.init();
    $scope.serviceName = ExamineeReportService.getStorageData();
  }
  
}]);