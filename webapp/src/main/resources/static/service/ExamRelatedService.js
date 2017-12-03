'use strict';
app.factory('ExamRelated', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('exam-related');
}])
/*******************************************************************************
 * ExamRelatedService
 ******************************************************************************/
.factory('ExamRelatedService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'ExamRelated', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, ExamRelated, Batch) {
    var factory = {
      init: init,
      getStorageData: getStorageData
    };
    return factory;

    function init() {
      console.log('Service(js): init()');
      ExamRelated.getList().then(function (result) {
        console.log('Controller(Java) response >> {}', result);
        $localStorage.ExamRelated = result;
      });
    }

    function getStorageData() {
      return $localStorage.ExamRelated;
    }
  }
]);