'use strict';
/*******************************************************************************
 * ExaminationNumberNumberingParameterService
 ******************************************************************************/
app.factory('ExaminationNumberNumberingParameterService', ['ExaminationNumberNumberingParameter', 'DievasConfig', 'Restangular', '$localStorage', '$http', '$q',
  function (ExaminationNumberNumberingParameter, DievasConfig, Restangular, $localStorage, $http, $q) {
    var factory = {
      init: init,
      getInitResult: getInitResult
    };
    return factory;

    function init() {
      console.log('ExaminationNumberNumberingParameterService.js: init()');
      ExaminationNumberNumberingParameter.getList().then(function (result) {
        console.log('Service name >> ' + result[0].message);
        $localStorage.result = result;
      });
    }

    function getInitResult() {
      return $localStorage.result;
    }
  }
]);