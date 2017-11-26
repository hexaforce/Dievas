'use strict';
/*******************************************************************************
 * ExamRelatedService
 ******************************************************************************/
app.factory('ExamRelatedService', ['ExamRelated', 'DievasConfig', 'Restangular', '$localStorage', '$http', '$q',
  function (ExamRelated, DievasConfig, Restangular, $localStorage, $http, $q) {
    var factory = {
      init: init,
      getInitResult: getInitResult
    };
    return factory;

    function init() {
      console.log('ExamRelatedService.js: init()');
      ExamRelated.getList().then(function (result) {
        console.log('Service name >> ' + result[0].message);
        $localStorage.result = result;
      });
    }

    function getInitResult() {
      return $localStorage.result;
    }
  }
]);