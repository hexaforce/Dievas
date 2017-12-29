'use strict';
/*******************************************************************************
 * OperatorListController
 ******************************************************************************/
app.controller('OperatorListController', ['OperatorListService', '$scope', function (OperatorListService, $scope) {
  
  $scope.init = function () {
    console.log('Controller(js): init()');
    OperatorListService.init();
    $scope.serviceName = OperatorListService.getStorageData();
  }
  
}]);