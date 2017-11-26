'use strict';
/*******************************************************************************
 * ExaminationNumberTemporaryProcessController
 ******************************************************************************/
app.controller('ExaminationNumberTemporaryProcessController', ['ExaminationNumberTemporaryProcessService', '$scope', function (ExaminationNumberTemporaryProcessService, $scope) {
  
  $scope.init = function () {
    console.log('ExaminationNumberTemporaryProcessController.js: init()');
    ExaminationNumberTemporaryProcessService.init();
    $scope.serviceName = ExaminationNumberTemporaryProcessService.getInitResult()[0].message;
  }
  
}]);