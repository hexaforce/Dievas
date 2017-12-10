'use strict';
var app = angular.module('Dievas', [ 'ui.router', 'ngStorage', 'restangular' ]);

/**************************************************************************
 * Dievas client side configuration parameter
 **************************************************************************/
app.constant('DievasConfig', {
  // TODO UI router や 　Restangular の パラメータをここでまとめて持ちたい
	API: 'v1',
  BASE: 'http://localhost:8082/',
  USER_SERVICE_API: 'http://localhost:8082/rest/actor/'
});


