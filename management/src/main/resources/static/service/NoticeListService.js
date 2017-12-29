'use strict';
app.factory('NoticeList', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('notice-list');
}])
/*******************************************************************************
 * NoticeListService
 ******************************************************************************/
.factory('NoticeListService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'NoticeList', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, NoticeList, Batch) {
    var factory = {
      init: init,
      getStorageData: getStorageData
    };
    return factory;

    function init() {
      console.log('Service(js): init()');
      NoticeList.getList().then(function (result) {
        console.log('Controller(Java) response >> {}', result);
        $localStorage.NoticeList = result;
      });
    }

    function getStorageData() {
      return $localStorage.NoticeList;
    }
  }
]);