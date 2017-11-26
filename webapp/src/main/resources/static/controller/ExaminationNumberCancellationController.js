'use strict';
/*******************************************************************************
 * ExaminationNumberCancellationController
 ******************************************************************************/
app.controller('ExaminationNumberCancellationController', ['ExaminationNumberCancellationService', '$scope', function (ExaminationNumberCancellationService, $scope) {
  
  $scope.init = function () {
    console.log('ExaminationNumberCancellationController.js: init()');
    ExaminationNumberCancellationService.init();
    $scope.serviceName = ExaminationNumberCancellationService.getInitResult()[0].message;
  }
  
}]);