'use strict';
/*******************************************************************************
 * ExaminationNumberCancellationController
 ******************************************************************************/
app.controller('ExaminationNumberCancellationController', ['ExaminationNumberCancellationService', '$scope', function (ExaminationNumberCancellationService, $scope) {
  
  $scope.init = function () {
    console.log('Controller(js): init()');
    ExaminationNumberCancellationService.init();
    $scope.serviceName = ExaminationNumberCancellationService.getStorageData();
  }
  
}]);