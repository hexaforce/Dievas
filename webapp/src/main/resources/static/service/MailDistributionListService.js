'use strict';
app.factory('MailDistributionList', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('mail-distribution-list');
}])
/*******************************************************************************
 * MailDistributionListService
 ******************************************************************************/
.factory('MailDistributionListService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'MailDistributionList', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, MailDistributionList, Batch) {
    var factory = {
      init: init,
      getStorageData: getStorageData
    };
    return factory;

    function init() {
      console.log('Service(js): init()');
      MailDistributionList.getList().then(function (result) {
        console.log('Controller(Java) response >> {}', result);
        $localStorage.MailDistributionList = result;
      });
    }

    function getStorageData() {
      return $localStorage.MailDistributionList;
    }
  }
]);