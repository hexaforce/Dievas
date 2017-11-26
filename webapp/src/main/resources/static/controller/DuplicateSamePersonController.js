'use strict';
/*******************************************************************************
 * DuplicateSamePersonController
 ******************************************************************************/
app.controller('DuplicateSamePersonController', ['DuplicateSamePersonService', '$scope', function (DuplicateSamePersonService, $scope) {
  
  $scope.init = function () {
    console.log('DuplicateSamePersonController.js: init()');
    DuplicateSamePersonService.init();
    $scope.serviceName = DuplicateSamePersonService.getInitResult()[0].message;
  }
  
}]);