'use strict';
/*******************************************************************************
 * FacePhotographsConfirmationController
 ******************************************************************************/
app.controller('FacePhotographsConfirmationController', ['FacePhotographsConfirmationService', '$scope', function (FacePhotographsConfirmationService, $scope) {
  
  $scope.init = function () {
    console.log('FacePhotographsConfirmationController.js: init()');
    FacePhotographsConfirmationService.init();
    $scope.serviceName = FacePhotographsConfirmationService.getInitResult()[0].message;
  }
  
}]);