'use strict';
/*******************************************************************************
 * ExamVoucherPassRejectionService
 ******************************************************************************/
app.factory('ExamVoucherPassRejectionService', ['ExamVoucherPassRejection', 'DievasConfig', 'Restangular', '$localStorage', '$http', '$q',
  function (ExamVoucherPassRejection, DievasConfig, Restangular, $localStorage, $http, $q) {
    var factory = {
      init: init,
      getInitResult: getInitResult
    };
    return factory;

    function init() {
      console.log('ExamVoucherPassRejectionService.js: init()');
      ExamVoucherPassRejection.getList().then(function (result) {
        console.log('Service name >> ' + result[0].message);
        $localStorage.result = result;
      });
    }

    function getInitResult() {
      return $localStorage.result;
    }
  }
]);