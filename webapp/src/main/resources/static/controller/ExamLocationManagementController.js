'use strict';
/*******************************************************************************
 * ExamLocationManagementController
 ******************************************************************************/
app.controller('ExamLocationManagementController', ['ExamLocationManagementService', '$scope', function (ExamLocationManagementService, $scope) {
  
  $scope.init = function () {
    console.log('ExamLocationManagementController.js: init()');
    ExamLocationManagementService.init();
    $scope.serviceName = ExamLocationManagementService.getInitResult()[0].message;
  }
  
}]);