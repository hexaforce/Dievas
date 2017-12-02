'use strict';
/*******************************************************************************
 * Dashboard angular service
 ******************************************************************************/
app.factory('JavaController', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('dashboard');
}])
.factory('DashboardService', ['JavaController', 'Batch', 'DievasConfig', 'Restangular', '$localStorage', '$http', '$q',
  function (JavaController, Batch, DievasConfig, Restangular, $localStorage, $http, $q) {
	
    var factory = {
      init: init,
      getLocalData: getLocalData,
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

    function getLocalData() {
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