'use strict';
app.factory('OperatorRegistration', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('operator-registration');
}])
/*******************************************************************************
 * OperatorRegistrationService
 ******************************************************************************/
.factory('OperatorRegistrationService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'OperatorRegistration', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, OperatorRegistration, Batch) {
    var factory = {
      init: init,
      getStorageData: getStorageData
    };
    return factory;

    function init() {
      console.log('Service(js): init()');
      OperatorRegistration.getList().then(function (result) {
        console.log('Controller(Java) response >> {}', result);
        $localStorage.OperatorRegistration = result;
      });
    }

    function getStorageData() {
      return $localStorage.OperatorRegistration;
    }
  }
]);