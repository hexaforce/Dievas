'use strict';
/*******************************************************************************
 * NoticeListService
 ******************************************************************************/
app.factory('NoticeListService', ['NoticeList', 'DievasConfig', 'Restangular', '$localStorage', '$http', '$q',
  function (NoticeList, DievasConfig, Restangular, $localStorage, $http, $q) {
    var factory = {
      init: init,
      getInitResult: getInitResult
    };
    return factory;

    function init() {
      console.log('NoticeListService.js: init()');
      NoticeList.getList().then(function (result) {
        console.log('Service name >> ' + result[0].message);
        $localStorage.result = result;
      });
    }

    function getInitResult() {
      return $localStorage.result;
    }
  }
]);