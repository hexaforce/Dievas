'use strict';
/*******************************************************************************
 * PaymentAndDocumentArrivedController
 ******************************************************************************/
app.controller('PaymentAndDocumentArrivedController', ['PaymentAndDocumentArrivedService', '$scope', function (PaymentAndDocumentArrivedService, $scope) {
  
  $scope.init = function () {
    console.log('Controller(js): init()');
    PaymentAndDocumentArrivedService.init();
    $scope.serviceName = PaymentAndDocumentArrivedService.getStorageData();
  }
  
}]);