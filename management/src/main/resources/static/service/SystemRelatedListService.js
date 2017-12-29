'use strict';
app.factory('SystemRelatedList', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('system-related-list');
}])
/*******************************************************************************
 * SystemRelatedListService
 ******************************************************************************/
.factory('SystemRelatedListService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'SystemRelatedList', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, SystemRelatedList, Batch) {
    var factory = {
      init: init,
      getStorageData: getStorageData
    };
    return factory;

    function init() {
      console.log('Service(js): init()');
      SystemRelatedList.getList().then(function (result) {
        console.log('Controller(Java) response >> {}', result);
        $localStorage.SystemRelatedList = result;
      });
    }

    function getStorageData() {
      return $localStorage.SystemRelatedList;
    }
  }
]);