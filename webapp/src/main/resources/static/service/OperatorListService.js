'use strict';
/*******************************************************************************
 * OperatorListService
 ******************************************************************************/
app.factory('OperatorListService', ['OperatorList', 'DievasConfig', 'Restangular', '$localStorage', '$http', '$q',
  function (OperatorList, DievasConfig, Restangular, $localStorage, $http, $q) {
    var factory = {
      init: init,
      getInitResult: getInitResult
    };
    return factory;

    function init() {
      console.log('OperatorListService.js: init()');
      OperatorList.getList().then(function (result) {
        console.log('Service name >> ' + result[0].message);
        $localStorage.result = result;
      });
    }

    function getInitResult() {
      return $localStorage.result;
    }
  }
]);