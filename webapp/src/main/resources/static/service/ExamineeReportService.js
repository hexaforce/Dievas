'use strict';
app.factory('ExamineeReport', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('examinee-report');
}])
/*******************************************************************************
 * ExamineeReportService
 ******************************************************************************/
.factory('ExamineeReportService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'ExamineeReport', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, ExamineeReport, Batch) {
    var factory = {
      init: init,
      getStorageData: getStorageData
    };
    return factory;

    function init() {
      console.log('Service(js): init()');
      ExamineeReport.getList().then(function (result) {
        console.log('Controller(Java) response >> {}', result);
        $localStorage.ExamineeReport = result;
      });
    }

    function getStorageData() {
      return $localStorage.ExamineeReport;
    }
  }
]);