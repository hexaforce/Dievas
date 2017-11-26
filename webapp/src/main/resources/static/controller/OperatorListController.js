'use strict';
/*******************************************************************************
 * OperatorListController
 ******************************************************************************/
app.controller('OperatorListController', ['OperatorListService', '$scope', function (OperatorListService, $scope) {
  
  $scope.init = function () {
    console.log('OperatorListController.js: init()');
    OperatorListService.init();
    $scope.serviceName = OperatorListService.getInitResult()[0].message;
  }
  
}]);