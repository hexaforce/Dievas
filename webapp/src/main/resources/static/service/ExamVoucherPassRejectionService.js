'use strict';
app.factory('ExamVoucherPassRejection', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('exam-voucher-pass-rejection');
}])
/*******************************************************************************
 * ExamVoucherPassRejectionService
 ******************************************************************************/
.factory('ExamVoucherPassRejectionService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'ExamVoucherPassRejection', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, ExamVoucherPassRejection, Batch) {
    var factory = {
      init: init,
      getStorageData: getStorageData
    };
    return factory;

    function init() {
      console.log('Service(js): init()');
      ExamVoucherPassRejection.getList().then(function (result) {
        console.log('Controller(Java) response >> {}', result);
        $localStorage.ExamVoucherPassRejection = result;
      });
    }

    function getStorageData() {
      return $localStorage.ExamVoucherPassRejection;
    }
  }
]);