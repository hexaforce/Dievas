'use strict';
/*******************************************************************************
 * PersonalInformationChangeRequestController
 ******************************************************************************/
app.controller('PersonalInformationChangeRequestController', ['PersonalInformationChangeRequestService', '$scope', function (PersonalInformationChangeRequestService, $scope) {
  
  $scope.init = function () {
    console.log('PersonalInformationChangeRequestController.js: init()');
    PersonalInformationChangeRequestService.init();
    $scope.serviceName = PersonalInformationChangeRequestService.getInitResult()[0].message;
  }
  
}]);