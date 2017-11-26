'use strict';
/*******************************************************************************
 * ExamineeReportService
 ******************************************************************************/
app.factory('ExamineeReportService', ['ExamineeReport', 'DievasConfig', 'Restangular', '$localStorage', '$http', '$q',
  function (ExamineeReport, DievasConfig, Restangular, $localStorage, $http, $q) {
    var factory = {
      init: init,
      getInitResult: getInitResult
    };
    return factory;

    function init() {
      console.log('ExamineeReportService.js: init()');
      ExamineeReport.getList().then(function (result) {
        console.log('Service name >> ' + result[0].message);
        $localStorage.result = result;
      });
    }

    function getInitResult() {
      return $localStorage.result;
    }
  }
]);