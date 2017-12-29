'use strict';
/*******************************************************************************
 * OperatorRegistrationController
 ******************************************************************************/
app.controller('OperatorRegistrationController', ['OperatorRegistrationService', '$scope', function (OperatorRegistrationService, $scope) {
  
  $scope.init = function () {
    console.log('Controller(js): init()');
    OperatorRegistrationService.init();
    $scope.serviceName = OperatorRegistrationService.getStorageData();
  }
  
}]);