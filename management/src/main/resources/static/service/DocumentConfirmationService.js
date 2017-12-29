'use strict';
app.factory('DocumentConfirmation', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('document-confirmation');
}])
/*******************************************************************************
 * DocumentConfirmationService
 ******************************************************************************/
.factory('DocumentConfirmationService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'DocumentConfirmation', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, DocumentConfirmation, Batch) {
    var factory = {
      init: init,
      getStorageData: getStorageData
    };
    return factory;

    function init() {
      console.log('Service(js): init()');
      DocumentConfirmation.getList().then(function (result) {
        console.log('Controller(Java) response >> {}', result);
        $localStorage.DocumentConfirmation = result;
      });
    }

    function getStorageData() {
      return $localStorage.DocumentConfirmation;
    }
  }
]);