'use strict';
app.factory('ExaminationNumberTemporaryProcess', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('examination-number-temporary-process');
}])
/*******************************************************************************
 * ExaminationNumberTemporaryProcessService
 ******************************************************************************/
.factory('ExaminationNumberTemporaryProcessService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'ExaminationNumberTemporaryProcess', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, ExaminationNumberTemporaryProcess, Batch) {
    var factory = {
      init: init,
      getStorageData: getStorageData
    };
    return factory;

    function init() {
      console.log('Service(js): init()');
      ExaminationNumberTemporaryProcess.getList().then(function (result) {
        console.log('Controller(Java) response >> {}', result);
        $localStorage.ExaminationNumberTemporaryProcess = result;
      });
    }

    function getStorageData() {
      return $localStorage.ExaminationNumberTemporaryProcess;
    }
  }
]);