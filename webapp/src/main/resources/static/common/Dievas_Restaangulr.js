'use strict';
/**************************************************************************
 * Restaangulr customize setting
 * see also >> https://github.com/mgonto/restangular#configuring-in-the-config
 **************************************************************************/
app.config(function(RestangularProvider) {
    RestangularProvider.setBaseUrl('/api/v1');
    RestangularProvider.setExtraFields(['name']);
    RestangularProvider.setResponseExtractor(function(response, operation) {
        return response.data;
    });

    RestangularProvider.addElementTransformer('accounts', false, function(element) {
       element.accountName = 'Changed';
       return element;
    });

    RestangularProvider.setDefaultHttpFields({cache: true});
    RestangularProvider.setMethodOverriders(["put", "patch"]);

    // In this case we are mapping the id of each element to the _id field.
    // We also change the Restangular route.
    // The default value for parentResource remains the same.
    RestangularProvider.setRestangularFields({
      id: "_id",
      route: "restangularRoute",
      selfLink: "self.href"
    });

    RestangularProvider.setRequestSuffix('.json');

    // Use Request interceptor
    RestangularProvider.setRequestInterceptor(function(element, operation, route, url) {
      delete element.name;
      return element;
    });

    // ..or use the full request interceptor, setRequestInterceptor's more powerful brother!
    RestangularProvider.setFullRequestInterceptor(function(element, operation, route, url, headers, params, httpConfig) {
      delete element.name;
      return {
        element: element,
        params: _.extend(params, {single: true}),
        headers: headers,
        httpConfig: httpConfig
      };
    });

});

//app.config(['RestangularProvider', function (RestangularProvider) {
//    RestangularProvider.setBaseUrl('http://localhost:8082/rest');
//    //RestangularProvider.setRequestSuffix('.json');
//    RestangularProvider.addResponseInterceptor(function (data, operation, what, url, response, deferred) {
//    	 
////        var extractedData;
////        if (operation === "getList") {  // getListを実行したときのレスポンスで返ってきたオブジェクトを整形する
////            if (data.list) {
////                extractedData = data.list || [];
////                extractedData.total = data.total;
////            } else {
////                extractedData = data;
////            }
////        } else {
////            extractedData = data;
////        }
////        return extractedData;
//    	return data;
//    });
//}]);
//app.run(function($rootScope, Restangular) {
//    Restangular.addFullRequestInterceptor(function (element, operation, route, url, headers, params, httpConfig) {
////        if (/*なんらかの条件*/) {
////            params.hoge = 'hoge';   // パラメータに変更を加える
////        }
//        return {
//            headers: headers,
//            params: params,
//            element: element,
//            httpConfig: httpConfig
//        };
//    });
//	
//    Restangular.setErrorInterceptor(
//            function (response, deferred, responseHandler) {
//                if (response.status == 404) {
//                    console.log("Resource not available...");
//                    $location.path('/notFound');
//                } else {
//                    console.log("Response received with HTTP error code: " + response.status );
//                }
//                console.log(response, deferred, responseHandler);
// 
//                //return false; // stop the promise chain
//            }
//        );
//	
////    Restangular.addRequestInterceptor(function(element) {
////        $rootScope.xhr = true;
////
////        return element;
////    });
////    Restangular.addResponseInterceptor(function(data) {
////        $rootScope.xhr = false;
////
////        return data;
////    });
//});
app.factory('Actor', ['Restangular', function (Restangular) {
    return Restangular.withConfig(function (config) {
    	
    }).service('actor');
}]);