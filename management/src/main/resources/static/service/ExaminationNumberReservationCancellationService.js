'use strict';
app.factory('ExaminationNumberReservationCancellation', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('examination-number-reservation-cancellation');
}])
/*******************************************************************************
 * ExaminationNumberReservationCancellationService
 ******************************************************************************/
.factory('ExaminationNumberReservationCancellationService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'ExaminationNumberReservationCancellation', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, ExaminationNumberReservationCancellation, Batch) {
    var factory = {
      init: init,
      getStorageData: getStorageData
    };
    return factory;

    function init() {
      console.log('Service(js): init()');
      ExaminationNumberReservationCancellation.getList().then(function (result) {
        console.log('Controller(Java) response >> {}', result);
        $localStorage.ExaminationNumberReservationCancellation = result;
      });
    }

    function getStorageData() {
      return $localStorage.ExaminationNumberReservationCancellation;
    }
  }
]);