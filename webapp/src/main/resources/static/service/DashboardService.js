'use strict';
/*******************************************************************************
 * DashboardService
 ******************************************************************************/
app.factory('DashboardService', ['Dashboard', 'DievasConfig', 'Restangular', '$localStorage', '$http', '$q',
  function (Dashboard, DievasConfig, Restangular, $localStorage, $http, $q) {
    var factory = {
      init: init,
      getInitResult: getInitResult
    };
    return factory;

    function init() {
      console.log('DashboardService.js: init()');
      Dashboard.getList().then(function (result) {
        console.log('Service name >> ' + result[0].message);
        $localStorage.result = result;
      });
    }

    function getInitResult() {
      return $localStorage.result;
    }
  }
]);