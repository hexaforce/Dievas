'use strict';
/*******************************************************************************
 * ExaminationNumberReservationCancellationController
 ******************************************************************************/
app.controller('ExaminationNumberReservationCancellationController', ['ExaminationNumberReservationCancellationService', '$scope', function (ExaminationNumberReservationCancellationService, $scope) {
  
  $scope.init = function () {
    console.log('ExaminationNumberReservationCancellationController.js: init()');
    ExaminationNumberReservationCancellationService.init();
    $scope.serviceName = ExaminationNumberReservationCancellationService.getInitResult()[0].message;
  }
  
}]);