'use strict';
/*******************************************************************************
 * DocumentConfirmationController
 ******************************************************************************/
app.controller('DocumentConfirmationController', ['DocumentConfirmationService', '$scope', function (DocumentConfirmationService, $scope) {
  
  $scope.init = function () {
    console.log('DocumentConfirmationController.js: init()');
    DocumentConfirmationService.init();
    $scope.serviceName = DocumentConfirmationService.getInitResult()[0].message;
  }
  
}]);