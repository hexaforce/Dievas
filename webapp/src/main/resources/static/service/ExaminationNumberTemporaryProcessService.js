'use strict';
/*******************************************************************************
 * ExaminationNumberTemporaryProcessService
 ******************************************************************************/
app.factory('ExaminationNumberTemporaryProcessService', ['ExaminationNumberTemporaryProcess', 'DievasConfig', 'Restangular', '$localStorage', '$http', '$q',
  function (ExaminationNumberTemporaryProcess, DievasConfig, Restangular, $localStorage, $http, $q) {
    var factory = {
      init: init,
      getInitResult: getInitResult
    };
    return factory;

    function init() {
      console.log('ExaminationNumberTemporaryProcessService.js: init()');
      ExaminationNumberTemporaryProcess.getList().then(function (result) {
        console.log('Service name >> ' + result[0].message);
        $localStorage.result = result;
      });
    }

    function getInitResult() {
      return $localStorage.result;
    }
  }
]);