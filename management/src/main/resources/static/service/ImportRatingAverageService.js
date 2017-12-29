'use strict';
app.factory('ImportRatingAverage', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('import-rating-average');
}])
/*******************************************************************************
 * ImportRatingAverageService
 ******************************************************************************/
.factory('ImportRatingAverageService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'ImportRatingAverage', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, ImportRatingAverage, Batch) {
    var factory = {
      init: init,
      getStorageData: getStorageData
    };
    return factory;

    function init() {
      console.log('Service(js): init()');
      ImportRatingAverage.getList().then(function (result) {
        console.log('Controller(Java) response >> {}', result);
        $localStorage.ImportRatingAverage = result;
      });
    }

    function getStorageData() {
      return $localStorage.ImportRatingAverage;
    }
  }
]);