'use strict';
app.factory('MailDeliveryRegistration', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('mail-delivery-registration');
}])
/*******************************************************************************
 * MailDeliveryRegistrationService
 ******************************************************************************/
.factory('MailDeliveryRegistrationService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'MailDeliveryRegistration', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, MailDeliveryRegistration, Batch) {
    var factory = {
      init: init,
      getStorageData: getStorageData
    };
    return factory;

    function init() {
      console.log('Service(js): init()');
      MailDeliveryRegistration.getList().then(function (result) {
        console.log('Controller(Java) response >> {}', result);
        $localStorage.MailDeliveryRegistration = result;
      });
    }

    function getStorageData() {
      return $localStorage.MailDeliveryRegistration;
    }
  }
]);