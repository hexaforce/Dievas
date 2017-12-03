'use strict';
app.factory('OperatorList', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('operator-list');
}])
/*******************************************************************************
 * OperatorListService
 ******************************************************************************/
.factory('OperatorListService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'OperatorList', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, OperatorList, Batch) {
    var factory = {
      init: init,
      getStorageData: getStorageData
    };
    return factory;

    function init() {
      console.log('Service(js): init()');
      OperatorList.getList().then(function (result) {
        console.log('Controller(Java) response >> {}', result);
        $localStorage.OperatorList = result;
      });
    }

    function getStorageData() {
      return $localStorage.OperatorList;
    }
  }
]);