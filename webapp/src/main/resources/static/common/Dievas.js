'use strict';
var app = angular.module('Dievas', [ 'ui.router', 'ngStorage', 'restangular' ]);

/**************************************************************************
 * Dievas client side configuration parameter
 **************************************************************************/
app.constant('urls', {
  BASE: 'http://localhost:8082/',
  USER_SERVICE_API: 'http://localhost:8082/rest/actor/'
});

/**************************************************************************
 * Restaangulr customize setting
 **************************************************************************/
app.config(['RestangularProvider', function (RestangularProvider) {
    RestangularProvider.setBaseUrl('http://localhost:8082/rest');
    //RestangularProvider.setRequestSuffix('.json');
    RestangularProvider.addResponseInterceptor(function (data, operation, what, url, response, deferred) {
    	 
//        var extractedData;
//        if (operation === "getList") {  // getListを実行したときのレスポンスで返ってきたオブジェクトを整形する
//            if (data.list) {
//                extractedData = data.list || [];
//                extractedData.total = data.total;
//            } else {
//                extractedData = data;
//            }
//        } else {
//            extractedData = data;
//        }
//        return extractedData;
    	return data;
    });
}]);
app.run(function($rootScope, Restangular) {
    Restangular.addFullRequestInterceptor(function (element, operation, route, url, headers, params, httpConfig) {
//        if (/*なんらかの条件*/) {
//            params.hoge = 'hoge';   // パラメータに変更を加える
//        }
        return {
            headers: headers,
            params: params,
            element: element,
            httpConfig: httpConfig
        };
    });
	
	
	
//    Restangular.addRequestInterceptor(function(element) {
//        $rootScope.xhr = true;
//
//        return element;
//    });
//    Restangular.addResponseInterceptor(function(data) {
//        $rootScope.xhr = false;
//
//        return data;
//    });
});
app.factory('Actor', ['Restangular', function (Restangular) {
    return Restangular.withConfig(function (config) {}).service('actor');
}]);

/**************************************************************************
 * Service
 *************************************************************************/
app.factory('UserService', ['$localStorage', '$http', '$q', 'urls', 'Actor',
  function ($localStorage, $http, $q, urls, Actor) {
    
	var factory = {
      loadAllUsers: loadAllUsers,
      getAllUsers: getAllUsers,
      getUser: getUser,
      createUser: createUser,
      updateUser: updateUser,
      removeUser: removeUser
    };
    return factory;

    function loadAllUsers() {
    	var x = Actor.getList();
      console.log('Fetching all users');
      var deferred = $q.defer();
      $http.get(urls.USER_SERVICE_API).then(function (response) {
        console.log('Fetched successfully all users');
        $localStorage.users = response.data;
        deferred.resolve(response);
      }, function (errResponse) {
        console.error('Error while loading users');
        deferred.reject(errResponse);
      });
      return deferred.promise;
    }

    function getAllUsers() {
      return $localStorage.users;
    }

    function getUser(id) {
      console.log('Fetching User with id :' + id);
      var deferred = $q.defer();
      $http.get(urls.USER_SERVICE_API + id).then(function (response) {
        console.log('Fetched successfully User with id :' + id);
        deferred.resolve(response.data);
      }, function (errResponse) {
        console.error('Error while loading user with id :' + id);
        deferred.reject(errResponse);
      });
      return deferred.promise;
    }

    function createUser(user) {
      console.log('Creating User');
      var deferred = $q.defer();
      $http.post(urls.USER_SERVICE_API, user).then(function (response) {
        loadAllUsers();
        deferred.resolve(response.data);
      }, function (errResponse) {
        console.error('Error while creating User : ' + errResponse.data.errorMessage);
        deferred.reject(errResponse);
      });
      return deferred.promise;
    }

    function updateUser(user, id) {
      console.log('Updating User with id ' + id);
      var deferred = $q.defer();
      $http.put(urls.USER_SERVICE_API + id, user).then(function (response) {
        loadAllUsers();
        deferred.resolve(response.data);
      }, function (errResponse) {
        console.error('Error while updating User with id :' + id);
        deferred.reject(errResponse);
      });
      return deferred.promise;
    }

    function removeUser(id) {
      console.log('Removing User with id ' + id);
      var deferred = $q.defer();
      $http.delete(urls.USER_SERVICE_API + id).then(function (response) {
        loadAllUsers();
        deferred.resolve(response.data);
      }, function (errResponse) {
        console.error('Error while removing User with id :' + id);
        deferred.reject(errResponse);
      });
      return deferred.promise;
    }
  }
]);

/*************************************************************************
 * Controller
 *************************************************************************/
app.controller('UserController', ['UserService', '$scope',
  function (UserService, $scope) {
	
    var self = this;
    self.user = {};
    self.users = [];
    self.submit = submit;
    self.getAllUsers = getAllUsers;
    self.createUser = createUser;
    self.updateUser = updateUser;
    self.removeUser = removeUser;
    self.editUser = editUser;
    self.reset = reset;
    self.successMessage = '';
    self.errorMessage = '';
    self.done = false;
    self.onlyIntegers = /^\d+$/;
    self.onlyNumbers = /^\d+([,.]\d+)?$/;

    function submit() {
      console.log('Submitting');
      if (self.user.id === undefined || self.user.id === null) {
        console.log('Saving New User', self.user);
        createUser(self.user);
      } else {
        updateUser(self.user, self.user.id);
        console.log('User updated with id ', self.user.id);
      }
    }

    function createUser(user) {
      console.log('About to create user');
      UserService.createUser(user).then(function (response) {
        console.log('User created successfully');
        self.successMessage = 'User created successfully';
        self.errorMessage = '';
        self.done = true;
        self.user = {};
        $scope.myForm.$setPristine();
      }, function (errResponse) {
        console.error('Error while creating User');
        self.errorMessage = 'Error while creating User: ' + errResponse.data.errorMessage;
        self.successMessage = '';
      });
    }

    function updateUser(user, id) {
      console.log('About to update user');
      UserService.updateUser(user, id).then(function (response) {
        console.log('User updated successfully');
        self.successMessage = 'User updated successfully';
        self.errorMessage = '';
        self.done = true;
        $scope.myForm.$setPristine();
      }, function (errResponse) {
        console.error('Error while updating User');
        self.errorMessage = 'Error while updating User ' + errResponse.data;
        self.successMessage = '';
      });
    }

    function removeUser(id) {
      console.log('About to remove User with id ' + id);
      UserService.removeUser(id).then(function () {
        console.log('User ' + id + ' removed successfully');
      }, function (errResponse) {
        console.error('Error while removing user ' + id + ', Error :' + errResponse.data);
      });
    }

    function getAllUsers() {
      return UserService.getAllUsers();
    }

    function editUser(id) {
      self.successMessage = '';
      self.errorMessage = '';
      UserService.getUser(id).then(function (user) {
        self.user = user;
      }, function (errResponse) {
        console.error('Error while removing user ' + id + ', Error :' + errResponse.data);
      });
    }

    function reset() {
      self.successMessage = '';
      self.errorMessage = '';
      self.user = {};
      $scope.myForm.$setPristine(); // reset Form
    }
    
  }
]);

/**************************************************************************
 * Router
 *************************************************************************/
app.config(['$stateProvider', '$urlRouterProvider',
  function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/');
    $stateProvider.state('index', {
      url: '/',
      templateUrl: 'content/dashboard',
      controller: 'UserController',
      controllerAs: 'ctrl'
    	  ,
      resolve: {
        users: function ($q, UserService) {
          console.log('Load all users');
          var deferred = $q.defer();
          UserService.loadAllUsers().then(deferred.resolve, deferred.resolve);
          return deferred.promise;
        }
      }
    });
  }
]);