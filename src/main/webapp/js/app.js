'use strict';
console.log('### app.js ###');

define(['angular', 'angular-animate', 'angular-route', 
        'bootstrap', 'angular-bootstrap'], function(angular) {
	console.log('= [app.js] define_callback');

	var app = angular.module('abtest.admin', ['ui.bootstrap', 'ngRoute']);

	app.init = function(){
		console.log('= [app.js] app.init()', document);
		angular.bootstrap(document, ['abtest.admin']);
	};
	
	return app;
});