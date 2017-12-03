'use strict';
app.factory('ApplicantPreliminaryReport', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('applicant-preliminary-report');
}])
/*******************************************************************************
 * ApplicantPreliminaryReportService
 ******************************************************************************/
.factory('ApplicantPreliminaryReportService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'ApplicantPreliminaryReport', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, ApplicantPreliminaryReport, Batch) {
    var factory = {
      init: init,
      getStorageData: getStorageData
    };
    return factory;

    function init() {
      console.log('Service(js): init()');
      ApplicantPreliminaryReport.getList().then(function (result) {
        console.log('Controller(Java) response >> {}', result);
        $localStorage.ApplicantPreliminaryReport = result;
      });
    }

    function getStorageData() {
      return $localStorage.ApplicantPreliminaryReport;
    }
  }
]);