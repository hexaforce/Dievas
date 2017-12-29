'use strict';
app.factory('ExaminationNumberCancellation', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('examination-number-cancellation');
}])
/*******************************************************************************
 * ExaminationNumberCancellationService
 ******************************************************************************/
.factory('ExaminationNumberCancellationService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'ExaminationNumberCancellation', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, ExaminationNumberCancellation, Batch) {
    var factory = {
      init: init,
      getStorageData: getStorageData
    };
    return factory;

    function init() {
      console.log('Service(js): init()');
      ExaminationNumberCancellation.getList().then(function (result) {
        console.log('Controller(Java) response >> {}', result);
        $localStorage.ExaminationNumberCancellation = result;
      });
    }

    function getStorageData() {
      return $localStorage.ExaminationNumberCancellation;
    }
  }
]);