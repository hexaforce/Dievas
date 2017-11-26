'use strict';
/*******************************************************************************
 * OperatorRegistrationController
 ******************************************************************************/
app.controller('OperatorRegistrationController', ['OperatorRegistrationService', '$scope', function (OperatorRegistrationService, $scope) {
  
  $scope.init = function () {
    console.log('OperatorRegistrationController.js: init()');
    OperatorRegistrationService.init();
    $scope.serviceName = OperatorRegistrationService.getInitResult()[0].message;
  }
  
}]);