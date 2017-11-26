'use strict';
/*******************************************************************************
 * MemberInformationSearchService
 ******************************************************************************/
app.factory('MemberInformationSearchService', ['MemberInformationSearch', 'DievasConfig', 'Restangular', '$localStorage', '$http', '$q',
  function (MemberInformationSearch, DievasConfig, Restangular, $localStorage, $http, $q) {
    var factory = {
      init: init,
      getInitResult: getInitResult
    };
    return factory;

    function init() {
      console.log('MemberInformationSearchService.js: init()');
      MemberInformationSearch.getList().then(function (result) {
        console.log('Service name >> ' + result[0].message);
        $localStorage.result = result;
      });
    }

    function getInitResult() {
      return $localStorage.result;
    }
  }
]);