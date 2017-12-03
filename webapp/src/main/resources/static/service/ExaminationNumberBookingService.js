'use strict';
app.factory('ExaminationNumberBooking', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('examination-number-booking');
}])
/*******************************************************************************
 * ExaminationNumberBookingService
 ******************************************************************************/
.factory('ExaminationNumberBookingService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'ExaminationNumberBooking', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, ExaminationNumberBooking, Batch) {
    var factory = {
      init: init,
      getStorageData: getStorageData
    };
    return factory;

    function init() {
      console.log('Service(js): init()');
      ExaminationNumberBooking.getList().then(function (result) {
        console.log('Controller(Java) response >> {}', result);
        $localStorage.ExaminationNumberBooking = result;
      });
    }

    function getStorageData() {
      return $localStorage.ExaminationNumberBooking;
    }
  }
]);