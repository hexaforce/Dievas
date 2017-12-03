'use strict';
app.factory('Dashboard', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('dashboard');
}])
/*******************************************************************************
 * DashboardService
 ******************************************************************************/
.factory('DashboardService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'Dashboard', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, Dashboard, Batch) {
    var factory = {
      init: init,
      getStorageData: getStorageData
    };
    return factory;

    function init() {
      console.log('Service(js): init()');
      Dashboard.getList().then(function (result) {
        console.log('Controller(Java) response >> {}', result);
        $localStorage.Dashboard = result;
      });
    }

    function getStorageData() {
      return $localStorage.Dashboard;
    }
  }
]);