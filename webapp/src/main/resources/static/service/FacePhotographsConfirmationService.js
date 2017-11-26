'use strict';
/*******************************************************************************
 * FacePhotographsConfirmationService
 ******************************************************************************/
app.factory('FacePhotographsConfirmationService', ['FacePhotographsConfirmation', 'DievasConfig', 'Restangular', '$localStorage', '$http', '$q',
  function (FacePhotographsConfirmation, DievasConfig, Restangular, $localStorage, $http, $q) {
    var factory = {
      init: init,
      getInitResult: getInitResult
    };
    return factory;

    function init() {
      console.log('FacePhotographsConfirmationService.js: init()');
      FacePhotographsConfirmation.getList().then(function (result) {
        console.log('Service name >> ' + result[0].message);
        $localStorage.result = result;
      });
    }

    function getInitResult() {
      return $localStorage.result;
    }
  }
]);