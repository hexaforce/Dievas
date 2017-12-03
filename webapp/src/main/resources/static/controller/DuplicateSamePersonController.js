'use strict';
/*******************************************************************************
 * DuplicateSamePersonController
 ******************************************************************************/
app.controller('DuplicateSamePersonController', ['DuplicateSamePersonService', '$scope', function (DuplicateSamePersonService, $scope) {
  
  $scope.init = function () {
    console.log('Controller(js): init()');
    DuplicateSamePersonService.init();
    $scope.serviceName = DuplicateSamePersonService.getStorageData();
  }
  
}]);