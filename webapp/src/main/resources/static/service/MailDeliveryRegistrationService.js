'use strict';
/*******************************************************************************
 * MailDeliveryRegistrationService
 ******************************************************************************/
app.factory('MailDeliveryRegistrationService', ['MailDeliveryRegistration', 'DievasConfig', 'Restangular', '$localStorage', '$http', '$q',
  function (MailDeliveryRegistration, DievasConfig, Restangular, $localStorage, $http, $q) {
    var factory = {
      init: init,
      getInitResult: getInitResult
    };
    return factory;

    function init() {
      console.log('MailDeliveryRegistrationService.js: init()');
      MailDeliveryRegistration.getList().then(function (result) {
        console.log('Service name >> ' + result[0].message);
        $localStorage.result = result;
      });
    }

    function getInitResult() {
      return $localStorage.result;
    }
  }
]);