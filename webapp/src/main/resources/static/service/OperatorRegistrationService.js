'use strict';
/*******************************************************************************
 * OperatorRegistrationService
 ******************************************************************************/
app.factory('OperatorRegistrationService', ['OperatorRegistration', 'DievasConfig', 'Restangular', '$localStorage', '$http', '$q',
  function (OperatorRegistration, DievasConfig, Restangular, $localStorage, $http, $q) {
    var factory = {
      init: init,
      getInitResult: getInitResult
    };
    return factory;

    function init() {
      console.log('OperatorRegistrationService.js: init()');
      OperatorRegistration.getList().then(function (result) {
        console.log('Service name >> ' + result[0].message);
        $localStorage.result = result;
      });
    }

    function getInitResult() {
      return $localStorage.result;
    }
  }
]);