'use strict';
/*******************************************************************************
 * ExaminationNumberBookingService
 ******************************************************************************/
app.factory('ExaminationNumberBookingService', ['ExaminationNumberBooking', 'DievasConfig', 'Restangular', '$localStorage', '$http', '$q',
  function (ExaminationNumberBooking, DievasConfig, Restangular, $localStorage, $http, $q) {
    var factory = {
      init: init,
      getInitResult: getInitResult
    };
    return factory;

    function init() {
      console.log('ExaminationNumberBookingService.js: init()');
      ExaminationNumberBooking.getList().then(function (result) {
        console.log('Service name >> ' + result[0].message);
        $localStorage.result = result;
      });
    }

    function getInitResult() {
      return $localStorage.result;
    }
  }
]);