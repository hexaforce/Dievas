'use strict';
app.factory('BatchJobExecutionHistory', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('batch-job-execution-history');
}])
/*******************************************************************************
 * BatchJobExecutionHistoryService
 ******************************************************************************/
.factory('BatchJobExecutionHistoryService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'BatchJobExecutionHistory', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, BatchJobExecutionHistory, Batch) {
    var factory = {
      init: init,
      getStorageData: getStorageData
    };
    return factory;

    function init() {
      console.log('Service(js): init()');
      BatchJobExecutionHistory.getList().then(function (result) {
        console.log('Controller(Java) response >> {}', result);
        $localStorage.BatchJobExecutionHistory = result;
      });
    }

    function getStorageData() {
      return $localStorage.BatchJobExecutionHistory;
    }
  }
]);