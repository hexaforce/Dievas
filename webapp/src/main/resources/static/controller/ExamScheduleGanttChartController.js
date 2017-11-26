'use strict';
/*******************************************************************************
 * ExamScheduleGanttChartController
 ******************************************************************************/
app.controller('ExamScheduleGanttChartController', ['ExamScheduleGanttChartService', '$scope', function (ExamScheduleGanttChartService, $scope) {
  
  $scope.init = function () {
    console.log('ExamScheduleGanttChartController.js: init()');
    ExamScheduleGanttChartService.init();
    $scope.serviceName = ExamScheduleGanttChartService.getInitResult()[0].message;
  }
  
}]);