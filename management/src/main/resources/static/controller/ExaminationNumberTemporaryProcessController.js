'use strict';
/*******************************************************************************
 * ExaminationNumberTemporaryProcessController
 ******************************************************************************/
app.controller('ExaminationNumberTemporaryProcessController', ['ExaminationNumberTemporaryProcessService', '$scope', function (ExaminationNumberTemporaryProcessService, $scope) {
  
  $scope.init = function () {
    console.log('Controller(js): init()');
    ExaminationNumberTemporaryProcessService.init();
    $scope.serviceName = ExaminationNumberTemporaryProcessService.getStorageData();
  }
  
}]);