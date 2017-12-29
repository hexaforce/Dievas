'use strict';
/*******************************************************************************
 * ChangeLogController
 ******************************************************************************/
app.controller('ChangeLogController', ['ChangeLogService', '$scope', function (ChangeLogService, $scope) {
  
  $scope.init = function () {
    console.log('Controller(js): init()');
    ChangeLogService.init();
    $scope.serviceName = ChangeLogService.getStorageData();
  }
  
}]);