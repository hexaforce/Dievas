'use strict';
/*******************************************************************************
 * ExamScheduleGanttChartController
 ******************************************************************************/
app.controller('ExamScheduleGanttChartController', ['ExamScheduleGanttChartService', '$scope', function (ExamScheduleGanttChartService, $scope) {
  
  $scope.init = function () {
    console.log('Controller(js): init()');
    ExamScheduleGanttChartService.init();
    $scope.serviceName = ExamScheduleGanttChartService.getStorageData();
  }
  
}]);