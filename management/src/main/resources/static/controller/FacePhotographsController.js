'use strict';
/*******************************************************************************
 * FacePhotographsController
 ******************************************************************************/
app.controller('FacePhotographsController', ['FacePhotographsService', '$scope', function (FacePhotographsService, $scope) {
  
  $scope.init = function () {
    console.log('Controller(js): init()');
    FacePhotographsService.init();
    $scope.serviceName = FacePhotographsService.getStorageData();
  }
  
}]);