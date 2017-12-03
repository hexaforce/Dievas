'use strict';
/*******************************************************************************
 * ImportRatingAverageController
 ******************************************************************************/
app.controller('ImportRatingAverageController', ['ImportRatingAverageService', '$scope', function (ImportRatingAverageService, $scope) {
  
  $scope.init = function () {
    console.log('Controller(js): init()');
    ImportRatingAverageService.init();
    $scope.serviceName = ImportRatingAverageService.getStorageData();
  }
  
}]);