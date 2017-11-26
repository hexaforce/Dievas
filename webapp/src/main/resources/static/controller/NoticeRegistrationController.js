'use strict';
/*******************************************************************************
 * NoticeRegistrationController
 ******************************************************************************/
app.controller('NoticeRegistrationController', ['NoticeRegistrationService', '$scope', function (NoticeRegistrationService, $scope) {
  
  $scope.init = function () {
    console.log('NoticeRegistrationController.js: init()');
    NoticeRegistrationService.init();
    $scope.serviceName = NoticeRegistrationService.getInitResult()[0].message;
  }
  
}]);