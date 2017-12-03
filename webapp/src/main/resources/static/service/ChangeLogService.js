'use strict';
app.factory('ChangeLog', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('change-log');
}])
/*******************************************************************************
 * ChangeLogService
 ******************************************************************************/
.factory('ChangeLogService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'ChangeLog', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, ChangeLog, Batch) {
    var factory = {
      init: init,
      getStorageData: getStorageData
    };
    return factory;

    function init() {
      console.log('Service(js): init()');
      ChangeLog.getList().then(function (result) {
        console.log('Controller(Java) response >> {}', result);
        $localStorage.ChangeLog = result;
      });
    }

    function getStorageData() {
      return $localStorage.ChangeLog;
    }
  }
]);