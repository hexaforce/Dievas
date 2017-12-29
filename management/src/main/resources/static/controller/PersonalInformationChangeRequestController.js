'use strict';
/*******************************************************************************
 * PersonalInformationChangeRequestController
 ******************************************************************************/
app.controller('PersonalInformationChangeRequestController', ['PersonalInformationChangeRequestService', '$scope', function (PersonalInformationChangeRequestService, $scope) {
  
  $scope.init = function () {
    console.log('Controller(js): init()');
    PersonalInformationChangeRequestService.init();
    $scope.serviceName = PersonalInformationChangeRequestService.getStorageData();
  }
  
}]);