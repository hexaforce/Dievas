'use strict';
app.factory('PracticalExaminationNumberManagement', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('practical-examination-number-management');
}])
/*******************************************************************************
 * PracticalExaminationNumberManagementService
 ******************************************************************************/
.factory('PracticalExaminationNumberManagementService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'PracticalExaminationNumberManagement', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, PracticalExaminationNumberManagement, Batch) {
    var factory = {
      init: init,
      getStorageData: getStorageData
    };
    return factory;

    function init() {
      console.log('Service(js): init()');
      PracticalExaminationNumberManagement.getList().then(function (result) {
        console.log('Controller(Java) response >> {}', result);
        $localStorage.PracticalExaminationNumberManagement = result;
      });
    }

    function getStorageData() {
      return $localStorage.PracticalExaminationNumberManagement;
    }
  }
]);