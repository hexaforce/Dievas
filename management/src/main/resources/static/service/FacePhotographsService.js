'use strict';
app.factory('FacePhotographs', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('face-photographs');
}])
/*******************************************************************************
 * FacePhotographsService
 ******************************************************************************/
.factory('FacePhotographsService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'FacePhotographs', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, FacePhotographs, Batch) {
    var factory = {
      init: init,
      getStorageData: getStorageData
    };
    return factory;

    function init() {
      console.log('Service(js): init()');
      FacePhotographs.getList().then(function (result) {
        console.log('Controller(Java) response >> {}', result);
        $localStorage.FacePhotographs = result;
      });
    }

    function getStorageData() {
      return $localStorage.FacePhotographs;
    }
  }
]);