'use strict';
/**************************************************************************
 * DashboardService
 **************************************************************************/
app.factory('DashboardService', ['Exam', 'DievasConfig', 'Restangular', '$localStorage', '$http', '$q',
  function (Exam, DievasConfig, Restangular, $localStorage, $http, $q) {
	var factory = {
      init:init	
	};
	return factory;
	function init(){
		Exam.getList();
      console.log('DashboardService: init()');
	}
  }
]);
