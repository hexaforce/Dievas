'use strict';
/*******************************************************************************
 * BatchJobExecutionHistoryService
 ******************************************************************************/
app.factory('BatchJobExecutionHistoryService', ['BatchJobExecutionHistory', 'DievasConfig', 'Restangular', '$localStorage', '$http', '$q',
  function (BatchJobExecutionHistory, DievasConfig, Restangular, $localStorage, $http, $q) {
    var factory = {
      init: init,
      getInitResult: getInitResult
    };
    return factory;

    function init() {
      console.log('BatchJobExecutionHistoryService.js: init()');
      BatchJobExecutionHistory.getList().then(function (result) {
        console.log('Service name >> ' + result[0].message);
        $localStorage.result = result;
      });
    }

    function getInitResult() {
      return $localStorage.result;
    }
  }
]);