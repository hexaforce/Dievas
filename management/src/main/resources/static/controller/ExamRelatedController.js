'use strict';
/*******************************************************************************
 * ExamRelatedController
 ******************************************************************************/
app.controller('ExamRelatedController', ['ExamRelatedService', '$scope', function (ExamRelatedService, $scope) {
  
  $scope.init = function () {
    console.log('Controller(js): init()');
    ExamRelatedService.init();
    $scope.serviceName = ExamRelatedService.getStorageData();
  }
  
}]);