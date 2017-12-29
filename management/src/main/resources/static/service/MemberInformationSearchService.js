'use strict';
app.factory('MemberInformationSearch', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('member-information-search');
}])
/*******************************************************************************
 * MemberInformationSearchService
 ******************************************************************************/
.factory('MemberInformationSearchService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'MemberInformationSearch', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, MemberInformationSearch, Batch) {
    var factory = {
      init: init,
      getStorageData: getStorageData
    };
    return factory;

    function init() {
      console.log('Service(js): init()');
      MemberInformationSearch.getList().then(function (result) {
        console.log('Controller(Java) response >> {}', result);
        $localStorage.MemberInformationSearch = result;
      });
    }

    function getStorageData() {
      return $localStorage.MemberInformationSearch;
    }
  }
]);