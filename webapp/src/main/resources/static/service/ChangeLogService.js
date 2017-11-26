'use strict';
/*******************************************************************************
 * ChangeLogService
 ******************************************************************************/
app.factory('ChangeLogService', ['ChangeLog', 'DievasConfig', 'Restangular', '$localStorage', '$http', '$q',
  function (ChangeLog, DievasConfig, Restangular, $localStorage, $http, $q) {
    var factory = {
      init: init,
      getInitResult: getInitResult
    };
    return factory;

    function init() {
      console.log('ChangeLogService.js: init()');
      ChangeLog.getList().then(function (result) {
        console.log('Service name >> ' + result[0].message);
        $localStorage.result = result;
      });
    }

    function getInitResult() {
      return $localStorage.result;
    }
  }
]);