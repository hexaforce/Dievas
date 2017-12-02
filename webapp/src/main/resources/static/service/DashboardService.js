'use strict';
/*******************************************************************************
 * DashboardService
 ******************************************************************************/
app.factory('DashboardService', ['Dashboard', 'DievasConfig', 'Restangular', '$localStorage', '$http', '$q',
  function (Dashboard, DievasConfig, Restangular, $localStorage, $http, $q) {
	
    var factory = {
      init: init,
      getLocalData: getLocalData
    };
    return factory;

    function init($scope) {
      console.log('DashboardService.js: init()');
      Dashboard.getList().then(function (result) {
        console.log('Service name >> ' + result[0].message);
        $localStorage.Dashboard = result;
      });
    }

    function getLocalData() {
      return $localStorage.Dashboard;
    }
    
  }
]);