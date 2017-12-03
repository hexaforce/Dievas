'use strict';
/*******************************************************************************
 * ImplementsReferenceController
 ******************************************************************************/
app.controller('ImplementsReferenceController', ['ImplementsReferenceService', '$scope', function (ImplementsReferenceService, $scope) {
  
  $scope.init = function () {
    console.log('Controller(js): init()');
    ImplementsReferenceService.init();
    $scope.serviceName = ImplementsReferenceService.getStorageData();
  }
  
}]);