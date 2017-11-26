'use strict';
/*******************************************************************************
 * FacePhotographsService
 ******************************************************************************/
app.factory('FacePhotographsService', ['FacePhotographs', 'DievasConfig', 'Restangular', '$localStorage', '$http', '$q',
  function (FacePhotographs, DievasConfig, Restangular, $localStorage, $http, $q) {
    var factory = {
      init: init,
      getInitResult: getInitResult
    };
    return factory;

    function init() {
      console.log('FacePhotographsService.js: init()');
      FacePhotographs.getList().then(function (result) {
        console.log('Service name >> ' + result[0].message);
        $localStorage.result = result;
      });
    }

    function getInitResult() {
      return $localStorage.result;
    }
  }
]);