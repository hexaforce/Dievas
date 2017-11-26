'use strict';
/*******************************************************************************
 * SystemRelatedListService
 ******************************************************************************/
app.factory('SystemRelatedListService', ['SystemRelatedList', 'DievasConfig', 'Restangular', '$localStorage', '$http', '$q',
  function (SystemRelatedList, DievasConfig, Restangular, $localStorage, $http, $q) {
    var factory = {
      init: init,
      getInitResult: getInitResult
    };
    return factory;

    function init() {
      console.log('SystemRelatedListService.js: init()');
      SystemRelatedList.getList().then(function (result) {
        console.log('Service name >> ' + result[0].message);
        $localStorage.result = result;
      });
    }

    function getInitResult() {
      return $localStorage.result;
    }
  }
]);