'use strict';
/*******************************************************************************
 * SystemRelatedListController
 ******************************************************************************/
app.controller('SystemRelatedListController', ['SystemRelatedListService', '$scope', function (SystemRelatedListService, $scope) {
  
  $scope.init = function () {
    console.log('Controller(js): init()');
    SystemRelatedListService.init();
    $scope.serviceName = SystemRelatedListService.getStorageData();
  }
  
}]);