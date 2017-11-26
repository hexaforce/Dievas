'use strict';
/*******************************************************************************
 * ExamineeReportController
 ******************************************************************************/
app.controller('ExamineeReportController', ['ExamineeReportService', '$scope', function (ExamineeReportService, $scope) {
  
  $scope.init = function () {
    console.log('ExamineeReportController.js: init()');
    ExamineeReportService.init();
    $scope.serviceName = ExamineeReportService.getInitResult()[0].message;
  }
  
}]);