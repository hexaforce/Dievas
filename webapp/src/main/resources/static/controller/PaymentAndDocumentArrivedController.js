'use strict';
/*******************************************************************************
 * PaymentAndDocumentArrivedController
 ******************************************************************************/
app.controller('PaymentAndDocumentArrivedController', ['PaymentAndDocumentArrivedService', '$scope', function (PaymentAndDocumentArrivedService, $scope) {
  
  $scope.init = function () {
    console.log('PaymentAndDocumentArrivedController.js: init()');
    PaymentAndDocumentArrivedService.init();
    $scope.serviceName = PaymentAndDocumentArrivedService.getInitResult()[0].message;
  }
  
}]);