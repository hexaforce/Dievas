'use strict';
/*******************************************************************************
 * PaymentAndDocumentArrivedService
 ******************************************************************************/
app.factory('PaymentAndDocumentArrivedService', ['PaymentAndDocumentArrived', 'DievasConfig', 'Restangular', '$localStorage', '$http', '$q',
  function (PaymentAndDocumentArrived, DievasConfig, Restangular, $localStorage, $http, $q) {
    var factory = {
      init: init,
      getInitResult: getInitResult
    };
    return factory;

    function init() {
      console.log('PaymentAndDocumentArrivedService.js: init()');
      PaymentAndDocumentArrived.getList().then(function (result) {
        console.log('Service name >> ' + result[0].message);
        $localStorage.result = result;
      });
    }

    function getInitResult() {
      return $localStorage.result;
    }
  }
]);