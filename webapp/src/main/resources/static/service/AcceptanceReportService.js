'use strict';
app.factory('AcceptanceReport', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('acceptance-report');
}])
/*******************************************************************************
 * AcceptanceReportService
 ******************************************************************************/
.factory('AcceptanceReportService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'AcceptanceReport', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, AcceptanceReport, Batch) {
    var factory = {
      init: init,
      getStorageData: getStorageData
    };
    return factory;

    function init() {
      console.log('Service(js): init()');
      AcceptanceReport.getList().then(function (result) {
        console.log('Controller(Java) response >> {}', result);
        $localStorage.AcceptanceReport = result;
      });
    }

    function getStorageData() {
      return $localStorage.AcceptanceReport;
    }
  }
]);