'use strict';
/*******************************************************************************
 * MailDeliveryRegistrationController
 ******************************************************************************/
app.controller('MailDeliveryRegistrationController', ['MailDeliveryRegistrationService', '$scope', function (MailDeliveryRegistrationService, $scope) {
  
  $scope.init = function () {
    console.log('Controller(js): init()');
    MailDeliveryRegistrationService.init();
    $scope.serviceName = MailDeliveryRegistrationService.getStorageData();
  }
  
}]);