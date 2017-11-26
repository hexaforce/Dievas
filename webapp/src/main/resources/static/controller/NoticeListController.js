'use strict';
/*******************************************************************************
 * NoticeListController
 ******************************************************************************/
app.controller('NoticeListController', ['NoticeListService', '$scope', function (NoticeListService, $scope) {
  
  $scope.init = function () {
    console.log('NoticeListController.js: init()');
    NoticeListService.init();
    $scope.serviceName = NoticeListService.getInitResult()[0].message;
  }
  
}]);