'use strict';
/*******************************************************************************
 * NoticeListController
 ******************************************************************************/
app.controller('NoticeListController', ['NoticeListService', '$scope', function (NoticeListService, $scope) {
  
  $scope.init = function () {
    console.log('Controller(js): init()');
    NoticeListService.init();
    $scope.serviceName = NoticeListService.getStorageData();
  }
  
}]);