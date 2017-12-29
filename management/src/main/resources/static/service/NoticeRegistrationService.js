'use strict';
app.factory('NoticeRegistration', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('notice-registration');
}])
/*******************************************************************************
 * NoticeRegistrationService
 ******************************************************************************/
.factory('NoticeRegistrationService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'NoticeRegistration', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, NoticeRegistration, Batch) {
    var factory = {
      init: init,
      getStorageData: getStorageData
    };
    return factory;

    function init() {
      console.log('Service(js): init()');
      NoticeRegistration.getList().then(function (result) {
        console.log('Controller(Java) response >> {}', result);
        $localStorage.NoticeRegistration = result;
      });
    }

    function getStorageData() {
      return $localStorage.NoticeRegistration;
    }
  }
]);