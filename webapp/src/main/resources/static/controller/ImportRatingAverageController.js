'use strict';
/*******************************************************************************
 * ImportRatingAverageController
 ******************************************************************************/
app.controller('ImportRatingAverageController', ['ImportRatingAverageService', '$scope', function (ImportRatingAverageService, $scope) {
  
  $scope.init = function () {
    console.log('ImportRatingAverageController.js: init()');
    ImportRatingAverageService.init();
    $scope.serviceName = ImportRatingAverageService.getInitResult()[0].message;
  }
  
}]);