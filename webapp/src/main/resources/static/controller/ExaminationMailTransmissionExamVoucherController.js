'use strict';
/*******************************************************************************
 * ExaminationMailTransmissionExamVoucherController
 ******************************************************************************/
app.controller('ExaminationMailTransmissionExamVoucherController', ['ExaminationMailTransmissionExamVoucherService', '$scope', function (ExaminationMailTransmissionExamVoucherService, $scope) {
  
  $scope.init = function () {
    console.log('Controller(js): init()');
    ExaminationMailTransmissionExamVoucherService.init();
    $scope.serviceName = ExaminationMailTransmissionExamVoucherService.getStorageData();
  }
  
}]);