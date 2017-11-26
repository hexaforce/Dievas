'use strict';
/*******************************************************************************
 * ChangeLogController
 ******************************************************************************/
app.controller('ChangeLogController', ['ChangeLogService', '$scope', function (ChangeLogService, $scope) {
  
  $scope.init = function () {
    console.log('ChangeLogController.js: init()');
    ChangeLogService.init();
    $scope.serviceName = ChangeLogService.getInitResult()[0].message;
  }
  
}]);