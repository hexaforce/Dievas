'use strict';
/*******************************************************************************
 * ExaminationNumberCancellationService
 ******************************************************************************/
app.factory('ExaminationNumberCancellationService', ['ExaminationNumberCancellation', 'DievasConfig', 'Restangular', '$localStorage', '$http', '$q',
  function (ExaminationNumberCancellation, DievasConfig, Restangular, $localStorage, $http, $q) {
    var factory = {
      init: init,
      getInitResult: getInitResult
    };
    return factory;

    function init() {
      console.log('ExaminationNumberCancellationService.js: init()');
      ExaminationNumberCancellation.getList().then(function (result) {
        console.log('Service name >> ' + result[0].message);
        $localStorage.result = result;
      });
    }

    function getInitResult() {
      return $localStorage.result;
    }
  }
]);