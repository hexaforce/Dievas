'use strict';

/**************************************************************************
 * Service
 *************************************************************************/
app.factory('UserSearchService', ['$localStorage', '$http', '$q', 'urls',
  function ($localStorage, $http, $q, urls) {
    var factory = {
      loadAllUsers: loadAllUsers
    };
    return factory;

    function loadAllUsers() {
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
  }
]);

/*************************************************************************
 * Controller
 *************************************************************************/
app.controller('UserSearchController', ['UserSearchService', '$scope',
  function (UserSearchService, $scope) {}
]);
