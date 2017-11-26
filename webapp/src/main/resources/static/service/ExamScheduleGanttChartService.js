'use strict';
/*******************************************************************************
 * ExamScheduleGanttChartService
 ******************************************************************************/
app.factory('ExamScheduleGanttChartService', ['ExamScheduleGanttChart', 'DievasConfig', 'Restangular', '$localStorage', '$http', '$q',
  function (ExamScheduleGanttChart, DievasConfig, Restangular, $localStorage, $http, $q) {
    var factory = {
      init: init,
      getInitResult: getInitResult
    };
    return factory;

    function init() {
      console.log('ExamScheduleGanttChartService.js: init()');
      ExamScheduleGanttChart.getList().then(function (result) {
        console.log('Service name >> ' + result[0].message);
        $localStorage.result = result;
      });
    }

    function getInitResult() {
      return $localStorage.result;
    }
  }
]);