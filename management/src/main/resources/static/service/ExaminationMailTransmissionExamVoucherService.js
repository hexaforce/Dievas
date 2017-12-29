'use strict';
app.factory('ExaminationMailTransmissionExamVoucher', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('examination-mail-transmission-exam-voucher');
}])
/*******************************************************************************
 * ExaminationMailTransmissionExamVoucherService
 ******************************************************************************/
.factory('ExaminationMailTransmissionExamVoucherService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'ExaminationMailTransmissionExamVoucher', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, ExaminationMailTransmissionExamVoucher, Batch) {
    var factory = {
      init: init,
      getStorageData: getStorageData
    };
    return factory;

    function init() {
      console.log('Service(js): init()');
      ExaminationMailTransmissionExamVoucher.getList().then(function (result) {
        console.log('Controller(Java) response >> {}', result);
        $localStorage.ExaminationMailTransmissionExamVoucher = result;
      });
    }

    function getStorageData() {
      return $localStorage.ExaminationMailTransmissionExamVoucher;
    }
  }
]);