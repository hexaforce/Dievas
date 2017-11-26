'use strict';
/*******************************************************************************
 * ExaminationNumberReservationCancellationService
 ******************************************************************************/
app.factory('ExaminationNumberReservationCancellationService', ['ExaminationNumberReservationCancellation', 'DievasConfig', 'Restangular', '$localStorage', '$http', '$q',
  function (ExaminationNumberReservationCancellation, DievasConfig, Restangular, $localStorage, $http, $q) {
    var factory = {
      init: init,
      getInitResult: getInitResult
    };
    return factory;

    function init() {
      console.log('ExaminationNumberReservationCancellationService.js: init()');
      ExaminationNumberReservationCancellation.getList().then(function (result) {
        console.log('Service name >> ' + result[0].message);
        $localStorage.result = result;
      });
    }

    function getInitResult() {
      return $localStorage.result;
    }
  }
]);