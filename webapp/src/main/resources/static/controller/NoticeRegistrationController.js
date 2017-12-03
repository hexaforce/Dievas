'use strict';
/*******************************************************************************
 * NoticeRegistrationController
 ******************************************************************************/
app.controller('NoticeRegistrationController', ['NoticeRegistrationService', '$scope', function (NoticeRegistrationService, $scope) {
  
  $scope.init = function () {
    console.log('Controller(js): init()');
    NoticeRegistrationService.init();
    $scope.serviceName = NoticeRegistrationService.getStorageData();
  }
  
}]);