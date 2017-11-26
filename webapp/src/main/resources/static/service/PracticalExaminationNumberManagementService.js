'use strict';
/*******************************************************************************
 * PracticalExaminationNumberManagementService
 ******************************************************************************/
app.factory('PracticalExaminationNumberManagementService', ['PracticalExaminationNumberManagement', 'DievasConfig', 'Restangular', '$localStorage', '$http', '$q',
  function (PracticalExaminationNumberManagement, DievasConfig, Restangular, $localStorage, $http, $q) {
    var factory = {
      init: init,
      getInitResult: getInitResult
    };
    return factory;

    function init() {
      console.log('PracticalExaminationNumberManagementService.js: init()');
      PracticalExaminationNumberManagement.getList().then(function (result) {
        console.log('Service name >> ' + result[0].message);
        $localStorage.result = result;
      });
    }

    function getInitResult() {
      return $localStorage.result;
    }
  }
]);