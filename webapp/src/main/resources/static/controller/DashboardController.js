'use strict';
/*******************************************************************************
 * DashboardController
 ******************************************************************************/
app.controller('DashboardController', ['DashboardService', '$scope',
	  function (DashboardService, $scope) {
	    $scope.init = function () {
	      console.log('DashboardController: init()');
	      DashboardService.init();
	    }
	  }
	]);