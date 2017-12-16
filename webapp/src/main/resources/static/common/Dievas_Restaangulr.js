'use strict';
/*******************************************************************************
 * Restaangulr customize setting
 * https://github.com/mgonto/restangular#configuring-in-the-config
 ******************************************************************************/
app.config(function (RestangularProvider) {
  // BaseUrl
  RestangularProvider.setBaseUrl('/datarest');
  //RestangularProvider.setRequestSuffix('.json');
  //RestangularProvider.setDefaultRequestParams({'X-CSRF-TOKEN' : $.cookie('XSRF-TOKEN')});
  
  // Request interceptor.
  RestangularProvider.setFullRequestInterceptor(
		  function (element, operation, route, url, headers, params, httpConfig) {
			  
	  console.log('[Request] Restangular:' + operation + ' URL:' + url);
	  var keyCheck = function (val){
		  return val != null && Object.keys(val).length;
	  }
		if (keyCheck(element))
			console.log('element:',element);
		if (keyCheck(params))
			console.log('params:',params);
		if (keyCheck(headers))
			console.log('headers:',headers);
		if (keyCheck(httpConfig))
			console.log('httpConfig:',httpConfig);

    return {
      element: element,
      params: params,
      headers: headers,
      httpConfig: httpConfig
    };
    
  });
  
  // Response interceptor.
  RestangularProvider.addResponseInterceptor(
		  function (data, operation, what, url, response, deferred) {
	  console.log('[Response] Restangular:' + operation + ' URL:' + url + '(' + response.config.method + ')' + ' response:' + response.status + '(' + response.statusText + ') xhr:' + response.xhrStatus);
	  
	  if (operation == 'getList' && response.status == 204){
		  if (url.indexOf("/api") == 0)
			  response.data = new Array();
	  }
	  
	  if (url.indexOf("/datarest") == 0)
		  return response.data._embedded[what];
	  if (url.indexOf("/api") == 0)
		  return response.data;
	  return response;
  });
  
  
  RestangularProvider.setErrorInterceptor(function(response, deferred, responseHandler) {
	    if(response.status === 403) {
	        refreshAccesstoken().then(function() {
	            // Repeat the request and then call the handlers the usual way.
	            $http(response.config).then(responseHandler, deferred.reject);
	            // Be aware that no request interceptors are called this way.
	        });
	        return false; // error handled
	    }
	    
	    if(response.status === 500) {
	    	if (response.data.message == "DievasException"){
	    		console.log(response.data);
	    		return false;
	    	}
	    }
	    
	    return true; // error not handled
	});
});

/******************************************************************************
 * Spring Data REST
 ******************************************************************************/
app.factory('Dashboard', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
	
  }).service('dashboard')
/******************************************************************************
 * Batch LunchUP REST
 ******************************************************************************/
}]).factory('Batch', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
	  RestangularConfigurer.setBaseUrl('/');
  }).service('batch');
}]);
