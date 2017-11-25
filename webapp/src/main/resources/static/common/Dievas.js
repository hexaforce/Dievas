'use strict';
var app = angular.module('Dievas', [ 'ui.router', 'ngStorage', 'restangular' ]);

/**************************************************************************
 * Dievas client side configuration parameter
 **************************************************************************/
app.constant('DievasConfig', {
  BASE: 'http://localhost:8082/',
  USER_SERVICE_API: 'http://localhost:8082/rest/actor/'
});


