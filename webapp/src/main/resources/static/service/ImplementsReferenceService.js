'use strict';
app.factory('ImplementsReference', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('implements-reference');
}])
/*******************************************************************************
 * ImplementsReferenceService
 ******************************************************************************/
.factory('ImplementsReferenceService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'ImplementsReference', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, ImplementsReference, Batch) {
    var factory = {
      init: init,
      getStorageData: getStorageData
    };
    return factory;

    function init() {
      console.log('Service(js): init()');
      ImplementsReference.getList().then(function (result) {
        console.log('Controller(Java) response >> {}', result);
        $localStorage.ImplementsReference = result;
      });
    }

    function getStorageData() {
      return $localStorage.ImplementsReference;
    }
  }
]);