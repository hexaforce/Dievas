'use strict';
app.factory('PersonalInformationChangeRequest', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('personal-information-change-request');
}])
/*******************************************************************************
 * PersonalInformationChangeRequestService
 ******************************************************************************/
.factory('PersonalInformationChangeRequestService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'PersonalInformationChangeRequest', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, PersonalInformationChangeRequest, Batch) {
    var factory = {
      init: init,
      getStorageData: getStorageData
    };
    return factory;

    function init() {
      console.log('Service(js): init()');
      PersonalInformationChangeRequest.getList().then(function (result) {
        console.log('Controller(Java) response >> {}', result);
        $localStorage.PersonalInformationChangeRequest = result;
      });
    }

    function getStorageData() {
      return $localStorage.PersonalInformationChangeRequest;
    }
  }
]);