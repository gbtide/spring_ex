'use strict';
console.log('### route.js ###');

define(['app', 'controller/temp', 'controller/listAll', 'controller/read', 'controller/listCri'], function(app) {
	console.log('= [route.js] define_callback');
	
	// angular.bootstrap이 호출된 뒤에 실행 됨
	app.config(function($routeProvider, $locationProvider){
		console.log('= [route.js] app.config_callback');
		
		$locationProvider.hashPrefix('!');
		
		$routeProvider.when('/temp', {
			templateUrl : '/html/partial/temp.html',
			controller : 'TempController'
		});
		
		$routeProvider.when('/success', {
			templateUrl : '/html/partial/success.html',
		});
		
		$routeProvider.when('/listAll', {
			templateUrl : '/html/partial/listAll.html',
			controller : 'ListAllController'
		});
		
		$routeProvider.when('/read', {
			templateUrl : '/html/partial/read.html',
			controller : 'ReadController'
		});
		
		$routeProvider.when('/listCri', {
			templateUrl : '/html/partial/listCri.html',
			controller : 'ListCriController'
		});
		
		$routeProvider.otherwise({
			redirectTo: '/'
		});
	});
});