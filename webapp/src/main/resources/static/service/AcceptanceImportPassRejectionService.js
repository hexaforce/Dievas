'use strict';
app.factory('AcceptanceImportPassRejection', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('acceptance-import-pass-rejection');
}])
/*******************************************************************************
 * AcceptanceImportPassRejectionService
 ******************************************************************************/
.factory('AcceptanceImportPassRejectionService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'AcceptanceImportPassRejection', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, AcceptanceImportPassRejection, Batch) {
    var factory = {
      init: init,
      getStorageData: getStorageData
    };
    return factory;

    function init() {
      console.log('Service(js): init()');
      AcceptanceImportPassRejection.getList().then(function (result) {
        console.log('Controller(Java) response >> {}', result);
        $localStorage.AcceptanceImportPassRejection = result;
      });
    }

    function getStorageData() {
      return $localStorage.AcceptanceImportPassRejection;
    }
  }
]);