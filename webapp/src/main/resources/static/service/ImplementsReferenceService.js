'use strict';
app.factory('ImplementsReference', ['Restangular', 'DievasConfig' , function (Restangular, DievasConfig) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl(DievasConfig.ORIGINAL_JAVA_IMPLEMENTS_CONTROLLER);  
  }).service('implements-reference');
}])
/*******************************************************************************
 * ImplementsReferenceService
 ******************************************************************************/
.factory('ImplementsReferenceService', ['$http', '$q', '$localStorage', 'DievasConfig', 'Restangular', 'ImplementsReference', 'Batch',
  function ($http, $q, $localStorage, DievasConfig, Restangular, ImplementsReference, Batch) {
    
	// サービスインターフェース
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
    
    // 初期化関数
    function init($scope) {
      console.log('Service(js): init()');
      ImplementsReference.get('init').then(function (result) {
        $localStorage.ImplementsReference = result;
        $scope.serviceName = result.message;
      });
    }
    
    // ローカルストレージ
    function getStorageData() {
      return $localStorage.ImplementsReference;
    }
    
    /***************************************
     *  angular標準でHTTPメソッドをコールする実装パターン
     ***************************************/
    function DefaultAction($scope) {
    	
    	// GET to /user
        function loadAllUsers() {
          var deferred = $q.defer();
          $http.get("http://localhost:8082/datarest/user").then(function (response) {
            $localStorage.users = response.data;
            deferred.resolve(response);
          }, function (errResponse) {
            deferred.reject(errResponse);
          });
          return deferred.promise;
        }

    	// GET to /user/{id}
        function getUser(id) {
          var deferred = $q.defer();
          $http.get("http://localhost:8082/datarest/user" + id).then(function (response) {
            deferred.resolve(response.data);
          }, function (errResponse) {
            deferred.reject(errResponse);
          });
          return deferred.promise;
        }

    	// POST to /user
        function createUser(user) {
          var deferred = $q.defer();
          $http.post("http://localhost:8082/datarest/user", user).then(function (response) {
            loadAllUsers();
            deferred.resolve(response.data);
          }, function (errResponse) {
            deferred.reject(errResponse);
          });
          return deferred.promise;
        }

    	// PUT to /user/{id}
        function updateUser(user, id) {
          var deferred = $q.defer();
          $http.put("http://localhost:8082/datarest/user" + id, user).then(function (response) {
            loadAllUsers();
            deferred.resolve(response.data);
          }, function (errResponse) {
            deferred.reject(errResponse);
          });
          return deferred.promise;
        }

    	// DELETE to /user/{id}
        function removeUser(id) {
          var deferred = $q.defer();
          $http.delete("http://localhost:8082/datarest/user" + id).then(function (response) {
            loadAllUsers();
            deferred.resolve(response.data);
          }, function (errResponse) {
            deferred.reject(errResponse);
          });
          return deferred.promise;
        }
        
     }

    /***************************************
     *  RestangularでHTTPメソッドをコールする実装パターン
     ***************************************/
    function PrimaryAction($scope) {
    	
/**
    	現在RestAPIは３タイプに分かれており、それぞれのRestangularインスタンスが容易されてきます。
    	
    	=================================================
    	１．Restangularインスタンス
    	=================================================
    	BaseURL:/datarest
    	Spring　Data RESTの実装です。
    	対応するコントローラはio.hexaforce.dievas.webapp.datarestパッケージにあります。
    	使い方は
    	Restangular.all('DBのテーブル名')
    	DBのテーブル名を指定するだけで直接DBへアクセスし基本的なCURD操作ができます。
    	
    	詳細は
    	https://docs.spring.io/spring-data/rest/docs/current/reference/html/
    	
    	=================================================
    	２．Batchインスタンス
    	=================================================
    	BaseURL:/batch/xxxxxxx
    	Spring Boot Batch の起動サービスです。
    	xxxxxxxにはジョブ名を指定して、パラメータ付きでコールしましす。
    	対応するコントローラはio.hexaforce.dievas.batch.BatchControllerです。
    	
    	詳細は
    	https://docs.spring.io/spring-batch/trunk/reference/html/
    	
    	=================================================
    	３．サービス名　（このjsではImplementsReference）
    	=================================================
    	BaseURL:/api/v1/xxxxxxx
    	独自実装のAPIをコールするためのものです。
    	対応するコントローラはio.hexaforce.dievas.webapp.controllerパッケージにあります。
    	
**/
    	
    	var baseExam = Restangular.all('user');
    	var newId = 1;
    	var newUser = {id: newId, name: 'Tantaka'};
    	
    	// GET to /user
    	Restangular.all('user').getList();
    	
    	// GET to /user/{id}
    	Restangular.all('user').get(newId);
    	
    	// POST to /user
    	Restangular.all('user').post(newUser);
    	
    	// PUT to /user/{id}
    	Restangular.all('user').getList().then(function (user) {

    		user.put(newUser);
    	}, function errorCallback() {
    	  alert("Oops error from server :(");
    	})
    	
    	// DELETE to /user/{id}
    	baseExam.delete(newId);
    	
    	/////////////////////////
    	// Restangularの注意事項
    	/////////////////////////
    	baseExam.getList().then(function (response) {
    		// angularの標準パターンにくらべ単体か配列かを明確にしなければなりません。Listで戻るときはgetList()です
    		$localStorage.users = response;
    	}, function errorCallback() {
    		// エラーのハンドリングは必須ではありませんが、ハンドリングすることもできます
      	  alert("Oops error from server :(");
      	});
    	
    }
    
    /***************************************
     *  Restangularでの様々なAPIをコールするパターン
     ***************************************/
    function SuccessAction($scope) {
    	
    	// Just ONE GET to /exam/123/buildings/456
    	Restangular.one('exam', 123).one('buildings', 456).get();

    	// Just ONE GET to /exam/123/buildings
    	Restangular.one('exam', 123).getList('buildings');
    	
    	
    	// GET to http://www.google.com/ You set the URL in this case
    	Restangular.allUrl('googlers', 'http://www.google.com/').getList();

    	// GET to http://www.google.com/1 You set the URL in this case
    	Restangular.oneUrl('googlers', 'http://www.google.com/1').get();
    	
    	
    	firstAccount.getList("users", {query: params});
    	
    	
  	  // PUT /exam/123. The name of this exam will be changed from now on
  	  firstAccount.put();
  	  editFirstAccount.put();

  	  // PUT /exam/123. Save will do POST or PUT accordingly
  	  firstAccount.save();

  	  // DELETE /exam/123 We don't have first exam anymore :(
  	  firstAccount.remove();

    //////////////////////////////
  	// Spring　Data REST の注意事項
  	//////////////////////////////
    }

    /***************************************
     *  バッチジョブ起動
     ***************************************/
    function InfoAction($scope) {
    	
    }

    /***************************************
     *  Restangularでの様々なAPIをコールするパターン
     ***************************************/
    function DangerAction($scope) {
    	ImplementsReference.one('test', 123).get();;
    }

    /***************************************
     *  独自実装APIパターン
     ***************************************/
    /***************************************
     *  Spring Data RESTを利用するパターン
     ***************************************/
    /***************************************
     *  Spring Data RESTを利用するパターン
     ***************************************/
    function DarkAction($scope) {
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
    	Restangular.one('exam', 123).one('buildings', 456).get();

    	// Just ONE GET to /exam/123/buildings
    	Restangular.one('exam', 123).getList('buildings');

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
     *  Spring Data RESTを利用するパターン
     ***************************************/
    function LinkAction($scope) {
    	Restangular.all('user_profile').getList().then(function (user_profile) {
    		$scope.user_profile = user_profile;
    	}, function errorCallback() {
      	  alert("Oops error from server :(");
      	});
    }
    
  }
]);