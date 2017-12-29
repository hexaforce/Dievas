'use strict';
app.factory('ExamLocationManagement', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('exam-location-management');
}])
/*******************************************************************************
 * ExamLocationManagementService
 ******************************************************************************/
.factory('ExamLocationManagementService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'ExamLocationManagement', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, ExamLocationManagement, Batch) {
    var factory = {
      init: init,
      getStorageData: getStorageData
    };
    return factory;

    function init() {
      console.log('Service(js): init()');
      ExamLocationManagement.getList().then(function (result) {
        console.log('Controller(Java) response >> {}', result);
        $localStorage.ExamLocationManagement = result;
      });
    }

    function getStorageData() {
      return $localStorage.ExamLocationManagement;
    }
  }
]);