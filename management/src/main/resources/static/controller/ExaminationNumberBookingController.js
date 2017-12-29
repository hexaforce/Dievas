'use strict';
/*******************************************************************************
 * ExaminationNumberBookingController
 ******************************************************************************/
app.controller('ExaminationNumberBookingController', ['ExaminationNumberBookingService', '$scope', function (ExaminationNumberBookingService, $scope) {
  
  $scope.init = function () {
    console.log('Controller(js): init()');
    ExaminationNumberBookingService.init();
    $scope.serviceName = ExaminationNumberBookingService.getStorageData();
  }
  
}]);