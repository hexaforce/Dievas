'use strict';
/*******************************************************************************
 * ExaminationNumberNumberingParameterController
 ******************************************************************************/
app.controller('ExaminationNumberNumberingParameterController', ['ExaminationNumberNumberingParameterService', '$scope', function (ExaminationNumberNumberingParameterService, $scope) {
  
  $scope.init = function () {
    console.log('ExaminationNumberNumberingParameterController.js: init()');
    ExaminationNumberNumberingParameterService.init();
    $scope.serviceName = ExaminationNumberNumberingParameterService.getInitResult()[0].message;
  }
  
}]);