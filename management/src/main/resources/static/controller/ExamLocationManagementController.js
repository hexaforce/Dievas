'use strict';
/*******************************************************************************
 * ExamLocationManagementController
 ******************************************************************************/
app.controller('ExamLocationManagementController', ['ExamLocationManagementService', '$scope', function (ExamLocationManagementService, $scope) {
  
  $scope.init = function () {
    console.log('Controller(js): init()');
    ExamLocationManagementService.init();
    $scope.serviceName = ExamLocationManagementService.getStorageData();
  }
  
}]);