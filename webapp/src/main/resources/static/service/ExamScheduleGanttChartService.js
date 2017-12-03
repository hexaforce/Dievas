'use strict';
app.factory('ExamScheduleGanttChart', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('exam-schedule-gantt-chart');
}])
/*******************************************************************************
 * ExamScheduleGanttChartService
 ******************************************************************************/
.factory('ExamScheduleGanttChartService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'ExamScheduleGanttChart', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, ExamScheduleGanttChart, Batch) {
    var factory = {
      init: init,
      getStorageData: getStorageData
    };
    return factory;

    function init() {
      console.log('Service(js): init()');
      ExamScheduleGanttChart.getList().then(function (result) {
        console.log('Controller(Java) response >> {}', result);
        $localStorage.ExamScheduleGanttChart = result;
      });
    }

    function getStorageData() {
      return $localStorage.ExamScheduleGanttChart;
    }
  }
]);