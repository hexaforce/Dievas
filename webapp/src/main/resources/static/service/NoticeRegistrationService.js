'use strict';
/*******************************************************************************
 * NoticeRegistrationService
 ******************************************************************************/
app.factory('NoticeRegistrationService', ['NoticeRegistration', 'DievasConfig', 'Restangular', '$localStorage', '$http', '$q',
  function (NoticeRegistration, DievasConfig, Restangular, $localStorage, $http, $q) {
    var factory = {
      init: init,
      getInitResult: getInitResult
    };
    return factory;

    function init() {
      console.log('NoticeRegistrationService.js: init()');
      NoticeRegistration.getList().then(function (result) {
        console.log('Service name >> ' + result[0].message);
        $localStorage.result = result;
      });
    }

    function getInitResult() {
      return $localStorage.result;
    }
  }
]);