'use strict';
app.factory('ProcessingStatusReport', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('processing-status-report');
}])
/*******************************************************************************
 * ProcessingStatusReportService
 ******************************************************************************/
.factory('ProcessingStatusReportService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'ProcessingStatusReport', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, ProcessingStatusReport, Batch) {
    var factory = {
      init: init,
      getStorageData: getStorageData
    };
    return factory;

    function init() {
      console.log('Service(js): init()');
      ProcessingStatusReport.getList().then(function (result) {
        console.log('Controller(Java) response >> {}', result);
        $localStorage.ProcessingStatusReport = result;
      });
    }

    function getStorageData() {
      return $localStorage.ProcessingStatusReport;
    }
  }
]);