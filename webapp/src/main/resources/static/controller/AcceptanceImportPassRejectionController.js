'use strict';
/*******************************************************************************
 * AcceptanceImportPassRejectionController
 ******************************************************************************/
app.controller('AcceptanceImportPassRejectionController', ['AcceptanceImportPassRejectionService', '$scope', function (AcceptanceImportPassRejectionService, $scope) {
  
  $scope.init = function () {
    console.log('AcceptanceImportPassRejectionController.js: init()');
    AcceptanceImportPassRejectionService.init();
    $scope.serviceName = AcceptanceImportPassRejectionService.getInitResult()[0].message;
  }
  
}]);