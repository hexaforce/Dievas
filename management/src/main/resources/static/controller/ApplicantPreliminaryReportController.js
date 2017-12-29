'use strict';
/*******************************************************************************
 * ApplicantPreliminaryReportController
 ******************************************************************************/
app.controller('ApplicantPreliminaryReportController', ['ApplicantPreliminaryReportService', '$scope', function (ApplicantPreliminaryReportService, $scope) {
  
  $scope.init = function () {
    console.log('Controller(js): init()');
    ApplicantPreliminaryReportService.init();
    $scope.serviceName = ApplicantPreliminaryReportService.getStorageData();
  }
  
}]);