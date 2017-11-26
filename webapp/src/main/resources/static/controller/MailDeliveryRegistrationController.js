'use strict';
/*******************************************************************************
 * MailDeliveryRegistrationController
 ******************************************************************************/
app.controller('MailDeliveryRegistrationController', ['MailDeliveryRegistrationService', '$scope', function (MailDeliveryRegistrationService, $scope) {
  
  $scope.init = function () {
    console.log('MailDeliveryRegistrationController.js: init()');
    MailDeliveryRegistrationService.init();
    $scope.serviceName = MailDeliveryRegistrationService.getInitResult()[0].message;
  }
  
}]);