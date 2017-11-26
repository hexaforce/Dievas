'use strict';
/*******************************************************************************
 * PracticalExaminationNumberManagementController
 ******************************************************************************/
app.controller('PracticalExaminationNumberManagementController', ['PracticalExaminationNumberManagementService', '$scope', function (PracticalExaminationNumberManagementService, $scope) {
  
  $scope.init = function () {
    console.log('PracticalExaminationNumberManagementController.js: init()');
    PracticalExaminationNumberManagementService.init();
    $scope.serviceName = PracticalExaminationNumberManagementService.getInitResult()[0].message;
  }
  
}]);