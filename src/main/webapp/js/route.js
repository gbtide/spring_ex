'use strict';
console.log('### route.js ###');

define(['app', 'controller/temp'], function(app) {
	console.log('= [route.js] define_callback');
	
	// angular.bootstrap이 호출된 뒤에 실행 됨
	app.config(function($routeProvider, $locationProvider){
		console.log('= [route.js] app.config_callback');
		
		$locationProvider.hashPrefix('!');
		
		$routeProvider.when('/temp', {
			templateUrl : '/html/partial/temp.html',
			controller : 'TempController'
		});
		
		$routeProvider.otherwise({
			redirectTo: '/'
		});
	});
});