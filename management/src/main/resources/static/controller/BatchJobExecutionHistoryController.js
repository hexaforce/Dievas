'use strict';
/*******************************************************************************
 * BatchJobExecutionHistoryController
 ******************************************************************************/
app.controller('BatchJobExecutionHistoryController', ['BatchJobExecutionHistoryService', '$scope', function (BatchJobExecutionHistoryService, $scope) {
  
  $scope.init = function () {
    console.log('Controller(js): init()');
    BatchJobExecutionHistoryService.init();
    $scope.serviceName = BatchJobExecutionHistoryService.getStorageData();
  }
  
}]);