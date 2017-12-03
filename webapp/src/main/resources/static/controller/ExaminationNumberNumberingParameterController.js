'use strict';
/*******************************************************************************
 * ExaminationNumberNumberingParameterController
 ******************************************************************************/
app.controller('ExaminationNumberNumberingParameterController', ['ExaminationNumberNumberingParameterService', '$scope', function (ExaminationNumberNumberingParameterService, $scope) {
  
  $scope.init = function () {
    console.log('Controller(js): init()');
    ExaminationNumberNumberingParameterService.init();
    $scope.serviceName = ExaminationNumberNumberingParameterService.getStorageData();
  }
  
}]);