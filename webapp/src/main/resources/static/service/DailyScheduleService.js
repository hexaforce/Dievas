'use strict';
app.factory('DailySchedule', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('daily-schedule');
}])
/*******************************************************************************
 * DailyScheduleService
 ******************************************************************************/
.factory('DailyScheduleService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'DailySchedule', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, DailySchedule, Batch) {
    var factory = {
      init: init,
      getStorageData: getStorageData
    };
    return factory;

    function init() {
      console.log('Service(js): init()');
      DailySchedule.getList().then(function (result) {
        console.log('Controller(Java) response >> {}', result);
        $localStorage.DailySchedule = result;
      });
    }

    function getStorageData() {
      return $localStorage.DailySchedule;
    }
  }
]);