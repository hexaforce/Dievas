'use strict';
/*******************************************************************************
 * ExaminationMailTransmissionExamVoucherController
 ******************************************************************************/
app.controller('ExaminationMailTransmissionExamVoucherController', ['ExaminationMailTransmissionExamVoucherService', '$scope', function (ExaminationMailTransmissionExamVoucherService, $scope) {
  
  $scope.init = function () {
    console.log('ExaminationMailTransmissionExamVoucherController.js: init()');
    ExaminationMailTransmissionExamVoucherService.init();
    $scope.serviceName = ExaminationMailTransmissionExamVoucherService.getInitResult()[0].message;
  }
  
}]);