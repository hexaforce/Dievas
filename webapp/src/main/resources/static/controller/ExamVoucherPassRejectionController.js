'use strict';
/*******************************************************************************
 * ExamVoucherPassRejectionController
 ******************************************************************************/
app.controller('ExamVoucherPassRejectionController', ['ExamVoucherPassRejectionService', '$scope', function (ExamVoucherPassRejectionService, $scope) {
  
  $scope.init = function () {
    console.log('ExamVoucherPassRejectionController.js: init()');
    ExamVoucherPassRejectionService.init();
    $scope.serviceName = ExamVoucherPassRejectionService.getInitResult()[0].message;
  }
  
}]);