'use strict';
/******************************************************************************
 * Dievas implement REST
 ******************************************************************************/
app.factory('JavaController', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('dashboard');
}])
/*******************************************************************************
 * Dashboard angular service
 ******************************************************************************/
.factory('DashboardService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'JavaController', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, JavaController, Batch) {
	
    var factory = {
      init: init,
      getStorageData: getStorageData,
      callJavaController: callJavaController,
      callSpringDataREST: callSpringDataREST,
      callBatchJob: callBatchJob
    };
    return factory;

    function init() {
      console.log('Service(js): init()');
      JavaController.getList().then(function (result) {
        console.log('Callback data >> ' + result[0].message);
        $localStorage.Dashboard = result;
      });
    }

    function getStorageData() {
      return $localStorage.Dashboard;
    }
    
    function callJavaController() {
    	JavaController.getList().then(function (Dashboard) {
           // $scope.accounts = accounts;
        });
    }

    function callSpringDataREST() {
        
    }
    
    function callBatchJob() {
    	Batch.one('job').get().then(function (batch) {
            //$scope.batch = batch;
        });
    }
    
    
    
    
    
    
    
    
  }
]);