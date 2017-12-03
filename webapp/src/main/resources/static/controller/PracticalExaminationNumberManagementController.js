'use strict';
/*******************************************************************************
 * PracticalExaminationNumberManagementController
 ******************************************************************************/
app.controller('PracticalExaminationNumberManagementController', ['PracticalExaminationNumberManagementService', '$scope', function (PracticalExaminationNumberManagementService, $scope) {
  
  $scope.init = function () {
    console.log('Controller(js): init()');
    PracticalExaminationNumberManagementService.init();
    $scope.serviceName = PracticalExaminationNumberManagementService.getStorageData();
  }
  
}]);