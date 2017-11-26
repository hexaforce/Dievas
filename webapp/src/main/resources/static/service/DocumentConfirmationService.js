'use strict';
/*******************************************************************************
 * DocumentConfirmationService
 ******************************************************************************/
app.factory('DocumentConfirmationService', ['DocumentConfirmation', 'DievasConfig', 'Restangular', '$localStorage', '$http', '$q',
  function (DocumentConfirmation, DievasConfig, Restangular, $localStorage, $http, $q) {
    var factory = {
      init: init,
      getInitResult: getInitResult
    };
    return factory;

    function init() {
      console.log('DocumentConfirmationService.js: init()');
      DocumentConfirmation.getList().then(function (result) {
        console.log('Service name >> ' + result[0].message);
        $localStorage.result = result;
      });
    }

    function getInitResult() {
      return $localStorage.result;
    }
  }
]);