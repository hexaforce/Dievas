'use strict';
/*******************************************************************************
 * MailDistributionListService
 ******************************************************************************/
app.factory('MailDistributionListService', ['MailDistributionList', 'DievasConfig', 'Restangular', '$localStorage', '$http', '$q',
  function (MailDistributionList, DievasConfig, Restangular, $localStorage, $http, $q) {
    var factory = {
      init: init,
      getInitResult: getInitResult
    };
    return factory;

    function init() {
      console.log('MailDistributionListService.js: init()');
      MailDistributionList.getList().then(function (result) {
        console.log('Service name >> ' + result[0].message);
        $localStorage.result = result;
      });
    }

    function getInitResult() {
      return $localStorage.result;
    }
  }
]);