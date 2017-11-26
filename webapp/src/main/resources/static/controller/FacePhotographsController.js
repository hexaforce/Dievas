'use strict';
/*******************************************************************************
 * FacePhotographsController
 ******************************************************************************/
app.controller('FacePhotographsController', ['FacePhotographsService', '$scope', function (FacePhotographsService, $scope) {
  
  $scope.init = function () {
    console.log('FacePhotographsController.js: init()');
    FacePhotographsService.init();
    $scope.serviceName = FacePhotographsService.getInitResult()[0].message;
  }
  
}]);