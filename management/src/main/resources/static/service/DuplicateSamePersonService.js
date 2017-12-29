'use strict';
app.factory('DuplicateSamePerson', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('duplicate-same-person');
}])
/*******************************************************************************
 * DuplicateSamePersonService
 ******************************************************************************/
.factory('DuplicateSamePersonService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'DuplicateSamePerson', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, DuplicateSamePerson, Batch) {
    var factory = {
      init: init,
      getStorageData: getStorageData
    };
    return factory;

    function init() {
      console.log('Service(js): init()');
      DuplicateSamePerson.getList().then(function (result) {
        console.log('Controller(Java) response >> {}', result);
        $localStorage.DuplicateSamePerson = result;
      });
    }

    function getStorageData() {
      return $localStorage.DuplicateSamePerson;
    }
  }
]);