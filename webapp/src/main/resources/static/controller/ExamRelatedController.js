'use strict';
/*******************************************************************************
 * ExamRelatedController
 ******************************************************************************/
app.controller('ExamRelatedController', ['ExamRelatedService', '$scope', function (ExamRelatedService, $scope) {
  
  $scope.init = function () {
    console.log('ExamRelatedController.js: init()');
    ExamRelatedService.init();
    $scope.serviceName = ExamRelatedService.getInitResult()[0].message;
  }
  
}]);