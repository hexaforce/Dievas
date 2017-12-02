'use strict';
/*******************************************************************************
 * Restaangulr customize setting
 * https://github.com/mgonto/restangular#configuring-in-the-config
 ******************************************************************************/
app.config(function (RestangularProvider) {
  // BaseUrl
  RestangularProvider.setBaseUrl('/');
  //RestangularProvider.setRequestSuffix('.json');
  //RestangularProvider.setDefaultRequestParams({key: 'abcdef'});
  // Request interceptor.
  RestangularProvider.setFullRequestInterceptor(function (element, operation, route, url, headers, params, httpConfig) {
	  console.log('[Request] Restangular:' + operation + ' URL:' + url);
    return {
      element: element,
      params: params,
      headers: headers,
      httpConfig: httpConfig
    };
  });
  // Response interceptor.
  RestangularProvider.addResponseInterceptor(function (data, operation, what, url, response, deferred) {
	  console.log('[Response] Restangular:' + operation + ' URL:' + url + '(' + response.config.method + ')' + ' response:' + response.status + '(' + response.statusText + ') xhr:' + response.xhrStatus);
	  if (url.indexOf("/rest") == 0)
		  return response.data.content;
	  if (url.indexOf("/api") == 0)
		  return response.data;
	  return response;
  });
});
/******************************************************************************
 * Dievas implement REST
 ******************************************************************************/
app.factory('API', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
	  
  }).service('api')
/******************************************************************************
 * Spring Data REST
 ******************************************************************************/
}]).factory('DataREST', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
	  
  }).service('datarest')
/******************************************************************************
 * Batch LunchUP REST
 ******************************************************************************/
}]).factory('Batch', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
	  
  }).service('batch');
}]);
