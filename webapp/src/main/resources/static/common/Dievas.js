'use strict';
var app = angular.module('Dievas', [ 'ui.router', 'ngStorage', 'restangular' ]);

/**************************************************************************
 * Dievas client side configuration parameter
 **************************************************************************/
app.constant('DievasConfig', {
	
  REST_ANGULAR_BASE: '/datarest',
  
  ORIGINAL_JAVA_IMPLEMENTS_CONTROLLER: '/api/v1',
  
  BATCH_CONTROLLER: '/batch'

});


