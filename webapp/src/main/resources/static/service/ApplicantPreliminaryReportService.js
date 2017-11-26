'use strict';
/*******************************************************************************
 * ApplicantPreliminaryReportService
 ******************************************************************************/
app.factory('ApplicantPreliminaryReportService', ['ApplicantPreliminaryReport', 'DievasConfig', 'Restangular', '$localStorage', '$http', '$q',
  function (ApplicantPreliminaryReport, DievasConfig, Restangular, $localStorage, $http, $q) {
    var factory = {
      init: init,
      getInitResult: getInitResult
    };
    return factory;

    function init() {
      console.log('ApplicantPreliminaryReportService.js: init()');
      ApplicantPreliminaryReport.getList().then(function (result) {
        console.log('Service name >> ' + result[0].message);
        $localStorage.result = result;
      });
    }

    function getInitResult() {
      return $localStorage.result;
    }
  }
]);