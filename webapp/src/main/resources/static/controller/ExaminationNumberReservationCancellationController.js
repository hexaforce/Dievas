'use strict';
/*******************************************************************************
 * ExaminationNumberReservationCancellationController
 ******************************************************************************/
app.controller('ExaminationNumberReservationCancellationController', ['ExaminationNumberReservationCancellationService', '$scope', function (ExaminationNumberReservationCancellationService, $scope) {
  
  $scope.init = function () {
    console.log('Controller(js): init()');
    ExaminationNumberReservationCancellationService.init();
    $scope.serviceName = ExaminationNumberReservationCancellationService.getStorageData();
  }
  
}]);