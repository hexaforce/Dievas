'use strict';
/*******************************************************************************
 * AcceptanceReportService
 ******************************************************************************/
app.factory('AcceptanceReportService', ['AcceptanceReport', 'DievasConfig', 'Restangular', '$localStorage', '$http', '$q',
  function (AcceptanceReport, DievasConfig, Restangular, $localStorage, $http, $q) {
    var factory = {
      init: init,
      getInitResult: getInitResult
    };
    return factory;

    function init() {
      console.log('AcceptanceReportService.js: init()');
      AcceptanceReport.getList().then(function (result) {
        console.log('Service name >> ' + result[0].message);
        $localStorage.result = result;
      });
    }

    function getInitResult() {
      return $localStorage.result;
    }
  }
]);