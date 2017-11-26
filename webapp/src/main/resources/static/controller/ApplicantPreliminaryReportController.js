'use strict';
/*******************************************************************************
 * ApplicantPreliminaryReportController
 ******************************************************************************/
app.controller('ApplicantPreliminaryReportController', ['ApplicantPreliminaryReportService', '$scope', function (ApplicantPreliminaryReportService, $scope) {
  
  $scope.init = function () {
    console.log('ApplicantPreliminaryReportController.js: init()');
    ApplicantPreliminaryReportService.init();
    $scope.serviceName = ApplicantPreliminaryReportService.getInitResult()[0].message;
  }
  
}]);