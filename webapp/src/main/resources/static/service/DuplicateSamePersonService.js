'use strict';
/*******************************************************************************
 * DuplicateSamePersonService
 ******************************************************************************/
app.factory('DuplicateSamePersonService', ['DuplicateSamePerson', 'DievasConfig', 'Restangular', '$localStorage', '$http', '$q',
  function (DuplicateSamePerson, DievasConfig, Restangular, $localStorage, $http, $q) {
    var factory = {
      init: init,
      getInitResult: getInitResult
    };
    return factory;

    function init() {
      console.log('DuplicateSamePersonService.js: init()');
      DuplicateSamePerson.getList().then(function (result) {
        console.log('Service name >> ' + result[0].message);
        $localStorage.result = result;
      });
    }

    function getInitResult() {
      return $localStorage.result;
    }
  }
]);