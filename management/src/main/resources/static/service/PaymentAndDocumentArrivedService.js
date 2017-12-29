'use strict';
app.factory('PaymentAndDocumentArrived', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('payment-and-document-arrived');
}])
/*******************************************************************************
 * PaymentAndDocumentArrivedService
 ******************************************************************************/
.factory('PaymentAndDocumentArrivedService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'PaymentAndDocumentArrived', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, PaymentAndDocumentArrived, Batch) {
    var factory = {
      init: init,
      getStorageData: getStorageData
    };
    return factory;

    function init() {
      console.log('Service(js): init()');
      PaymentAndDocumentArrived.getList().then(function (result) {
        console.log('Controller(Java) response >> {}', result);
        $localStorage.PaymentAndDocumentArrived = result;
      });
    }

    function getStorageData() {
      return $localStorage.PaymentAndDocumentArrived;
    }
  }
]);