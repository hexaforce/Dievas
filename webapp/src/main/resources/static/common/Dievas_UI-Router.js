'use strict';
/**************************************************************************
 * Router
 *************************************************************************/
app.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
    
	$urlRouterProvider.otherwise('/');
    
    $stateProvider
    .state('index', {
      url: '/',
      templateUrl: 'content/dashboard',
      controller: 'UserController',
      controllerAs: 'ctrl'
//    	  ,
//      resolve: {
//          users: function (UserService) {return UserService.loadAllUsers();}
////        users: function ($q, UserService) {
////          console.log('Load all users');
////          var deferred = $q.defer();
////          UserService.loadAllUsers().then(deferred.resolve, deferred.resolve);
////          return deferred.promise;
////        }
//      }
    })
    .state('UserSearch', {
        url: '/user-search',
        templateUrl: 'content/user-search',
        controller: 'UserSearchController',
        controllerAs: 'ctrl'
//        	,
//        resolve: {
//          usersSearch: function ($q, UserSearchService) {
//            console.log('UserSearchService');
//            var deferred = $q.defer();
//            UserSearchService.loadAllUsers().then(deferred.resolve, deferred.resolve);
//            return deferred.promise;
//          }
//        }
      });
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  }
]);