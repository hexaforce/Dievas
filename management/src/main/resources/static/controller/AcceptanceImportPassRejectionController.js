'use strict';
/*******************************************************************************
 * AcceptanceImportPassRejectionController
 ******************************************************************************/
app.controller('AcceptanceImportPassRejectionController', ['AcceptanceImportPassRejectionService', '$scope', function (AcceptanceImportPassRejectionService, $scope) {
  
  $scope.init = function () {
    console.log('Controller(js): init()');
    AcceptanceImportPassRejectionService.init();
    $scope.serviceName = AcceptanceImportPassRejectionService.getStorageData();
  }
  
}]);