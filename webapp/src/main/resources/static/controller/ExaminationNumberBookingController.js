'use strict';
/*******************************************************************************
 * ExaminationNumberBookingController
 ******************************************************************************/
app.controller('ExaminationNumberBookingController', ['ExaminationNumberBookingService', '$scope', function (ExaminationNumberBookingService, $scope) {
  
  $scope.init = function () {
    console.log('ExaminationNumberBookingController.js: init()');
    ExaminationNumberBookingService.init();
    $scope.serviceName = ExaminationNumberBookingService.getInitResult()[0].message;
  }
  
}]);