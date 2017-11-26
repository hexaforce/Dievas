'use strict';
/*******************************************************************************
 * PersonalInformationChangeRequestService
 ******************************************************************************/
app.factory('PersonalInformationChangeRequestService', ['PersonalInformationChangeRequest', 'DievasConfig', 'Restangular', '$localStorage', '$http', '$q',
  function (PersonalInformationChangeRequest, DievasConfig, Restangular, $localStorage, $http, $q) {
    var factory = {
      init: init,
      getInitResult: getInitResult
    };
    return factory;

    function init() {
      console.log('PersonalInformationChangeRequestService.js: init()');
      PersonalInformationChangeRequest.getList().then(function (result) {
        console.log('Service name >> ' + result[0].message);
        $localStorage.result = result;
      });
    }

    function getInitResult() {
      return $localStorage.result;
    }
  }
]);