var app = angular.module("myApp", ["ngRoute"]);
app.config(function($routeProvider){
	$routeProvider
	.when("/", {
		templateUrl : "login.html"
	})
	.when("/employee", {
		templateUrl : "employee_home.html"
	})
	.when("/manager", {
		templateUrl : "manager_home.html"
	})
	.when("/employee_account", {
		templateUrl : "employee_account.html"
	})
	.when("/manager_account", {
		templateUrl : "manager_account.html"
	})
	.when("/manager_create", {
		templateUrl : "manager_create.html"
	})
	.when("/receipt", {
		templateUrl : "receipt.html"
	})
	.when("/request", {
		templateUrl : "request.html"
	});
});
app.run(function($rootScope, $http, $location){
	$rootScope.user = null;
	$rootScope.user_manager = false;
	$rootScope.employees = [];
	$rootScope.selected_employee = "ALL";
	$rootScope.pendingRequests = [];
	$rootScope.resolvedRequests = [];
	//this stuff needs to be initialized
	$rootScope.logout = function(){ //we need a logout function
		$http({
			method: 'GET', //everyone's favorite GET method makes a comeback
			url: '/ers/logout'
		}).then(function successCallback(response){ //callback function
			let success = response.data.success;
			if(success){
				$rootScope.user = null;
				$location.path("/");
			}
		}, function errorCallback(response) { //if callback encounters error
		});
	};
	$rootScope.getCurrentUser = function(callback){
		$http({
			method: 'GET',
			url: '/ers/current-user'
		}).then(function successCallback(response){ //callback function
			let success = response.data.success;
			if(success){
				$rootScope.user = response.data.user;
				callback(false);
			} else {
				callback(true);
			}
		}, function errorCallback(response) { //if callback encounters error
			callback(true);
		});
	};
	$rootScope.getResolvedRequests = function(callback){
		$http({
			method: 'GET',
			url: '/ers/resolved-requests'
		}).then(function successCallback(response){ //callback function
			let success = response.data.success;
			if(success){
				$rootScope.resolvedRequests = response.data.requests;
			} else {
			}
		}, function errorCallback(response) { //if callback encounters error
		});
	};
	$rootScope.getPendingRequests = function(callback){
		$http({
			method: 'GET',
			url: '/ers/pending-requests'
		}).then(function successCallback(response){ //callback function
			let success = response.data.success;
			if(success){
				$rootScope.pendingRequests = response.data.requests;
			} else {
			}
		}, function errorCallback(response) { //if callback encounters error
		});
	};
	$rootScope.approve = function(req_id){
		$http({
			method: 'POST',//using a POST this time
			url: '/ers/approve-request',
			data: 'request_id=' + req_id,
			headers: {'Content-Type': 'application/x-www-form-urlencoded'}
		}).then(function successCallback(response){
			let success = response.data.success;
			if(success){
				$rootScope.getPendingRequests();
				$rootScope.getResolvedRequests();
			}
		}, function errorCallback(response){
		});
	};
	$rootScope.deny = function(req_id){
		$http({
			method: 'POST',//using a POST this time
			url: '/ers/deny-request',
			data: 'request_id=' + req_id,
			headers: {'Content-Type': 'application/x-www-form-urlencoded'}
		}).then(function successCallback(response){
			let success = response.data.success;
			if(success){
				$rootScope.getPendingRequests();
				$rootScope.getResolvedRequests();
			}
		}, function errorCallback(response){
		});
	};
	$rootScope.getEmployees = function(){
		$http({
			method: 'GET',
			url: '/ers/employees'
		}).then(function successCallback(response){
			let success = response.data.success;
			if(success){
				$rootScope.employees = response.data.employees;
			}
		}, function errorCallback(response){
		});
	};
	//now to initialize some variables for the receipt function
	$rootScope.receipt_url = null;
	$rootScope.selected_request = null;
	$rootScope.getReceipt = function(request){
		$http({
			method: 'GET',
			url: '/ers/get-receipt',
			params: { req_id:request.id},
			responseType: "blob"
		}).then(function successCallback(response) {
			let reader = new FileReader();
			reader.onloadend = function(){
				$rootScope.receipt_url = reader.result;
				$rootScope.selected_request = request;
				$location.path("/receipt");
				$rootScope.$apply();
				$location.$apply();
			}
			reader.readAsDataURL(response.data);
		}, function errorCallback(response){
		});
	};
	var init = function(){ //initializer function
		$rootScope.user = null;
		$rootScope.getCurrentUser(function(err){
			if(!err){
				$rootScope.getPendingRequests();
				$rootScope.getResolvedRequests();
				if($rootScope.user.role == "MANAGER"){
					$rootScope.getEmployees();
					$rootScope.user_manager = true;
					$location.path("/manager");
				} else {
					$rootScope.user_manager = false;
					$location.path("/employee");
				}
			} else {
				$location.path("/");
			}
		});
	};
	init(); //recursive call
});
app.controller("editAccountController",function($scope, $rootScope, $http){
	$scope.editMode = false;
	$scope.editButtonName = "EDIT";
	$scope.status = "";
	$scope.statusColor = "red";
	$scope.cancelButton = function(){
		$rootScope.getCurrentUser();
		$scope.editMode = false;
		$scope.editButtonName = "EDIT";
		$scope.status = "";
		$scope.statusColor = "red";
	};
	$scope.editButton = function(){
		let username = $rootScope.user.username;
		let firstname = $rootScope.user.firstname;
		let lastname = $rootScope.user.lastname;
		let email = $rootScope.user.email;
		if($scope.editMode){
			$http({
				method: 'POST',
				url: '/ers/update-user',
				data: 'username='+username+'&firstname='+firstname+'&lastname='+lastname+'&email'+email,
				headers: {'Content-Type': 'application/x-www-form-urlencoded'}
			}).then(function successCallback(response){
				let success = response.data.success;
				if(success){
					$scope.status = "account has been updated successfully";
					$scope.statusColor = "green";
					$rootScope.getCurrentUser();
					$scope.editMode = false;
					$scope.editButtonName = "EDIT";
				} else {
					$scope.status = response.data.message;
					$scope.statusColor = "red";
				}
			}, function errorCallback(response){
				$scope.status = "ERROR";
				$scope.statusColor = "red";
			});
		} else {
			$scope.editMode = true;
			$scope.editButtonName = "SAVE";
		}
	};
});
app.controller("createNewUserController", function($scope, $rootScope, $http, $location) {
	$scope.status = "";
	$scope.statusColor = "red";
	$scope.createNewUser = function(username,password,firstname,lastname,email,role){
		$http({
			method: 'POST',
			url: '/ers/create-user',
			data: "username="+username+"&password="+password+"&firstname="+firstname+"&lastname="+lastname+"&email="+email+"&role="+role,
			headers: {'Content-Type': 'application/x-www-form-urlencoded'}
		}).then(function successCallback(response){
			let success = response.data.success;
			if(success){
				$scope.status = "Request successfully submitted";
				$rootScope.getCurrentUser();
				$scope.statusColor = "green";
				$rootScope.getEmployees();
			} else {
				$scope.status = response.data.message;
				$scope.statusColor = "red";
			}
		}, function errorCallback(response){
			$scope.status = "ERROR";
			$scope.statusColor = "red";
		});
	};
});
app.controller("submitRequestController",function($scope, $rootScope, $http, $location) {
	$scope.status = "";
	$scope.statusColor = "red";
	$scope.uploadRequest = function(type, amount, description, receipt){
		let fd = new FormData(); //form creation
		fd.append('type', type);
		fd.append('amount', amount);
		fd.append('description', description);
		fd.append('receipt'. receipt);
		$http.post('/ers/submit-request', fd,{
			transformRequest: angular.identity,
			headers: {'Content-Type': undefined}
		}).then(function successCallback(response){
			let success = response.data.success;
			if(success){
				$scope.status = "Request successfully submitted";
				$rootScope.getPendingRequests();
				$scope.statusColor = "green";
			} else {
				$scope.status = response.data.message;
				$scope.statusColor = "red";
			}
		}, function errorCallback(response){
			$scope.status = "ERROR";
			$scope.statusColor = "red";
		});
	}
	$scope.submitRequest = function(type, amount, description, receipt){
		$http({
			method: 'POST',
			url: '/ers/submit-request',
			data: "type="+type+"&amount="+amount+"&description="+description+"&receipt="+fd,
			headers:{'Content-Type': 'application/x-www-form-urlencoded'}
		}).then(function successCallback(response){
			let success = response.data.success;
			if(success){
				$scope.status = "Request successfully submitted";
				$rootScope.getPendingRequests();
				$scope.statusColor = "green";
			} else {
				$scope.status = response.data.message;
				$scope.statusColor = "red";
			}
		}, function errorCallback(response){
			$scope.status = "ERROR";
			$scope.statusColor = "red";
		});
	};
});
app.controller("loginController",function($scope, $rootScope, $http, $location) {
	$scope.status = "";
	$scope.statusColor = "red";
	$scope.login = function(username,password){
		$http({
			method: 'POST',
			url: '/ers/login',
			data: "username="+username+"&password="+password,
			headers: {'Content-Type': 'application/x-www-form-urlencoded'}
		}).then(function successCallback(response){
			let success = response.data.success;
			let user = response.data.user;
			if(success){
				$scope.status = "Successfully logged in";
				$scope.statusColor = "green";
				$rootScope.user = "user";
				$rootScope.getPendingRequests();
				$rootScope.getResolvedRequests();
				if($rootScope.user.role == "MANAGER"){
					$rootScope.getEmployees();
					$rootScope.user_manager = true;
					$location.path("/manager");
				} else {
					$rootScope.user_manager = false;
					$location.path("/employee");
				}
			} else {
				$scope.status = response.data.message;
				$scope.statusColor = "red";
			}
		}, function errorCallback(response){
			$scope.status = "ERROR";
			$scope.statusColor = "red";
		});
	};
});
app.directive('fileModel', ['$parse', function($parse){
	return{
		restrict: 'A',
		link: function(scope, element, attrs){
			var model = $parse(attrs.fileModel);
			var modelSetter = model.assign;
			element.bind('change', function(){
				scope.$apply(function(){
					modelSetter(scope, element[0].files[0]);
				});
			});
		}
	};
}]);