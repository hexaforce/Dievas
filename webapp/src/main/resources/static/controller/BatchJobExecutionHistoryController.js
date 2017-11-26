'use strict';
/*******************************************************************************
 * BatchJobExecutionHistoryController
 ******************************************************************************/
app.controller('BatchJobExecutionHistoryController', ['BatchJobExecutionHistoryService', '$scope', function (BatchJobExecutionHistoryService, $scope) {
  
  $scope.init = function () {
    console.log('BatchJobExecutionHistoryController.js: init()');
    BatchJobExecutionHistoryService.init();
    $scope.serviceName = BatchJobExecutionHistoryService.getInitResult()[0].message;
  }
  
}]);