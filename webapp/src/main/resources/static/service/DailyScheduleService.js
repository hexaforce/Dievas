'use strict';
/*******************************************************************************
 * DailyScheduleService
 ******************************************************************************/
app.factory('DailyScheduleService', ['DailySchedule', 'DievasConfig', 'Restangular', '$localStorage', '$http', '$q',
  function (DailySchedule, DievasConfig, Restangular, $localStorage, $http, $q) {
    var factory = {
      init: init,
      getInitResult: getInitResult
    };
    return factory;

    function init() {
      console.log('DailyScheduleService.js: init()');
      DailySchedule.getList().then(function (result) {
        console.log('Service name >> ' + result[0].message);
        $localStorage.result = result;
      });
    }

    function getInitResult() {
      return $localStorage.result;
    }
  }
]);