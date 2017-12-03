'use strict';
/*******************************************************************************
 * FacePhotographsConfirmationController
 ******************************************************************************/
app.controller('FacePhotographsConfirmationController', ['FacePhotographsConfirmationService', '$scope', function (FacePhotographsConfirmationService, $scope) {
  
  $scope.init = function () {
    console.log('Controller(js): init()');
    FacePhotographsConfirmationService.init();
    $scope.serviceName = FacePhotographsConfirmationService.getStorageData();
  }
  
}]);