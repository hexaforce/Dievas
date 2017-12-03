'use strict';
app.factory('ImplementsReference', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');  
  }).service('implements-reference');
}])
/*******************************************************************************
 * ImplementsReferenceService
 ******************************************************************************/
.factory('ImplementsReferenceService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'ImplementsReference', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, ImplementsReference, Batch) {
    var factory = {
      init: init,
      getStorageData: getStorageData,
      DefaultAction: DefaultAction,
      PrimaryAction: PrimaryAction,
      SuccessAction: SuccessAction,
      InfoAction: InfoAction,
      DangerAction: DangerAction,
      DarkAction: DarkAction,
      LinkAction: LinkAction
    };
    return factory;

    function init() {
      console.log('Service(js): init()');
      ImplementsReference.getList().then(function (result) {
        console.log('Controller(Java) response >> {}', result);
        $localStorage.ImplementsReference = result;
      });
    }

    function getStorageData() {
      return $localStorage.ImplementsReference;
    }
    
    /***************************************
     *  angular 標準実装パターン
     ***************************************/
    function DefaultAction($scope) {

    }
    
    /***************************************
     *  Spring Data RESTを利用するパターン
     ***************************************/
    function PrimaryAction($scope) {
    	
    	// First way of creating a Restangular object. Just saying the base URL
    	var baseExam = Restangular.all('exam');

    	// This will query /exam and return a promise.
    	baseExam.getList().then(function(exam) {
    	  $scope.allExam = exam;
    	});

    	// Does a GET to /exam
    	// Returns an empty array by default. Once a value is returned from the server
    	// that array is filled with those values. So you can use this in your template
    	$scope.exam = Restangular.all('exam').getList().$object;

    	var newAccount = {name: "Gonto's exam"};

    	// POST /exam
    	baseExam.post(newAccount);

    	// GET to http://www.google.com/ You set the URL in this case
    	Restangular.allUrl('googlers', 'http://www.google.com/').getList();

    	// GET to http://www.google.com/1 You set the URL in this case
    	Restangular.oneUrl('googlers', 'http://www.google.com/1').get();

    	// You can do RequestLess "connections" if you need as well

    	// Just ONE GET to /exam/123/buildings/456
    	Restangular.one('exam', 123).one('buildings', 456).get()

    	// Just ONE GET to /exam/123/buildings
    	Restangular.one('exam', 123).getList('buildings')

    	// Here we use Promises then
    	// GET /exam
    	baseExam.getList().then(function (exam) {
    	  // Here we can continue fetching the tree :).

    	  var firstAccount = exam[0];
    	  // This will query /exam/123/buildings considering 123 is the id of the firstAccount
    	  $scope.buildings = firstAccount.getList("buildings");

    	  // GET /exam/123/places?query=param with request header: x-user:mgonto
    	  $scope.loggedInPlaces = firstAccount.getList("places", {query: 'param'}, {'x-user': 'mgonto'})

    	  // This is a regular JS object, we can change anything we want :)
    	  firstAccount.name = "Gonto"

    	  // If we wanted to keep the original as it is, we can copy it to a new element
    	  var editFirstAccount = Restangular.copy(firstAccount);
    	  editFirstAccount.name = "New Name";


    	  // PUT /exam/123. The name of this exam will be changed from now on
    	  firstAccount.put();
    	  editFirstAccount.put();

    	  // PUT /exam/123. Save will do POST or PUT accordingly
    	  firstAccount.save();

    	  // DELETE /exam/123 We don't have first exam anymore :(
    	  firstAccount.remove();

    	  var myBuilding = {
    	    name: "Gonto's Building",
    	    place: "Argentina"
    	  };

    	  // POST /exam/123/buildings with MyBuilding information
    	  firstAccount.post("Buildings", myBuilding).then(function() {
    	    console.log("Object saved OK");
    	  }, function() {
    	    console.log("There was an error saving");
    	  });

    	  // GET /exam/123/users?query=params
    	  firstAccount.getList("users", {query: params}).then(function(users) {
    	    // Instead of posting nested element, a collection can post to itself
    	    // POST /exam/123/users
    	    users.post({userName: 'unknown'});

    	    // Custom methods are available now :).
    	    // GET /exam/123/users/messages?param=myParam
    	    users.customGET("messages", {param: "myParam"})

    	    var firstUser = users[0];

    	    // GET /exam/123/users/456. Just in case we want to update one user :)
    	    $scope.userFromServer = firstUser.get();

    	    // ALL http methods are available :)
    	    // HEAD /exam/123/users/456
    	    firstUser.head()

    	  });

    	}, function errorCallback() {
    	  alert("Oops error from server :(");
    	})

    	// Second way of creating Restangular object. URL and ID :)
    	var exam = Restangular.one("exam", 123);

    	// GET /exam/123?single=true
    	$scope.exam = exam.get({single: true});

    	// POST /exam/123/messages?param=myParam with the body of name: "My Message"
    	exam.customPOST({name: "My Message"}, "messages", {param: "myParam"}, {})
    	
    }

    /***************************************
     *  独自実装APIパターン
     ***************************************/
    function SuccessAction($scope) {
    	// ImplementsReference
    }

    /***************************************
     *  バッチジョブ起動
     ***************************************/
    function InfoAction($scope) {
    	
    }

    /***************************************
     *  Spring Data RESTを利用するパターン
     ***************************************/
    function DangerAction($scope) {
    	
    }

    /***************************************
     *  Spring Data RESTを利用するパターン
     ***************************************/
    function DarkAction($scope) {
    	
    }

    /***************************************
     *  Spring Data RESTを利用するパターン
     ***************************************/
    function LinkAction($scope) {
    	
    }
    
  }
]);