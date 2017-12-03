'use strict';
app.factory('ExaminationNumberNumberingParameter', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('examination-number-numbering-parameter');
}])
/*******************************************************************************
 * ExaminationNumberNumberingParameterService
 ******************************************************************************/
.factory('ExaminationNumberNumberingParameterService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'ExaminationNumberNumberingParameter', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, ExaminationNumberNumberingParameter, Batch) {
    var factory = {
      init: init,
      getStorageData: getStorageData
    };
    return factory;

    function init() {
      console.log('Service(js): init()');
      ExaminationNumberNumberingParameter.getList().then(function (result) {
        console.log('Controller(Java) response >> {}', result);
        $localStorage.ExaminationNumberNumberingParameter = result;
      });
    }

    function getStorageData() {
      return $localStorage.ExaminationNumberNumberingParameter;
    }
  }
]);