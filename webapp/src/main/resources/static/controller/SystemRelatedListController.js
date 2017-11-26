'use strict';
/*******************************************************************************
 * SystemRelatedListController
 ******************************************************************************/
app.controller('SystemRelatedListController', ['SystemRelatedListService', '$scope', function (SystemRelatedListService, $scope) {
  
  $scope.init = function () {
    console.log('SystemRelatedListController.js: init()');
    SystemRelatedListService.init();
    $scope.serviceName = SystemRelatedListService.getInitResult()[0].message;
  }
  
}]);