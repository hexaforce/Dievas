'use strict';
/*******************************************************************************
 * ProcessingStatusReportService
 ******************************************************************************/
app.factory('ProcessingStatusReportService', ['ProcessingStatusReport', 'DievasConfig', 'Restangular', '$localStorage', '$http', '$q',
  function (ProcessingStatusReport, DievasConfig, Restangular, $localStorage, $http, $q) {
    var factory = {
      init: init,
      getInitResult: getInitResult
    };
    return factory;

    function init() {
      console.log('ProcessingStatusReportService.js: init()');
      ProcessingStatusReport.getList().then(function (result) {
        console.log('Service name >> ' + result[0].message);
        $localStorage.result = result;
      });
    }

    function getInitResult() {
      return $localStorage.result;
    }
  }
]);