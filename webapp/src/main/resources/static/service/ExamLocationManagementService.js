'use strict';
/*******************************************************************************
 * ExamLocationManagementService
 ******************************************************************************/
app.factory('ExamLocationManagementService', ['ExamLocationManagement', 'DievasConfig', 'Restangular', '$localStorage', '$http', '$q',
  function (ExamLocationManagement, DievasConfig, Restangular, $localStorage, $http, $q) {
    var factory = {
      init: init,
      getInitResult: getInitResult
    };
    return factory;

    function init() {
      console.log('ExamLocationManagementService.js: init()');
      ExamLocationManagement.getList().then(function (result) {
        console.log('Service name >> ' + result[0].message);
        $localStorage.result = result;
      });
    }

    function getInitResult() {
      return $localStorage.result;
    }
  }
]);