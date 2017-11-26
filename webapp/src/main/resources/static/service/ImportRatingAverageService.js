'use strict';
/*******************************************************************************
 * ImportRatingAverageService
 ******************************************************************************/
app.factory('ImportRatingAverageService', ['ImportRatingAverage', 'DievasConfig', 'Restangular', '$localStorage', '$http', '$q',
  function (ImportRatingAverage, DievasConfig, Restangular, $localStorage, $http, $q) {
    var factory = {
      init: init,
      getInitResult: getInitResult
    };
    return factory;

    function init() {
      console.log('ImportRatingAverageService.js: init()');
      ImportRatingAverage.getList().then(function (result) {
        console.log('Service name >> ' + result[0].message);
        $localStorage.result = result;
      });
    }

    function getInitResult() {
      return $localStorage.result;
    }
  }
]);