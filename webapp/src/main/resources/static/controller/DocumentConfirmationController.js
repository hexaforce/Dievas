'use strict';
/*******************************************************************************
 * DocumentConfirmationController
 ******************************************************************************/
app.controller('DocumentConfirmationController', ['DocumentConfirmationService', '$scope', function (DocumentConfirmationService, $scope) {
  
  $scope.init = function () {
    console.log('Controller(js): init()');
    DocumentConfirmationService.init();
    $scope.serviceName = DocumentConfirmationService.getStorageData();
  }
  
}]);