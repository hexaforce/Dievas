'use strict';
/*******************************************************************************
 * ExamVoucherPassRejectionController
 ******************************************************************************/
app.controller('ExamVoucherPassRejectionController', ['ExamVoucherPassRejectionService', '$scope', function (ExamVoucherPassRejectionService, $scope) {
  
  $scope.init = function () {
    console.log('Controller(js): init()');
    ExamVoucherPassRejectionService.init();
    $scope.serviceName = ExamVoucherPassRejectionService.getStorageData();
  }
  
}]);