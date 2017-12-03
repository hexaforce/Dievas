'use strict';
app.factory('FacePhotographsConfirmation', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('face-photographs-confirmation');
}])
/*******************************************************************************
 * FacePhotographsConfirmationService
 ******************************************************************************/
.factory('FacePhotographsConfirmationService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'FacePhotographsConfirmation', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, FacePhotographsConfirmation, Batch) {
    var factory = {
      init: init,
      getStorageData: getStorageData
    };
    return factory;

    function init() {
      console.log('Service(js): init()');
      FacePhotographsConfirmation.getList().then(function (result) {
        console.log('Controller(Java) response >> {}', result);
        $localStorage.FacePhotographsConfirmation = result;
      });
    }

    function getStorageData() {
      return $localStorage.FacePhotographsConfirmation;
    }
  }
]);