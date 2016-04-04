'use strict';

define(['angular', 'angular-animate', 'bootstrap', 'angular-bootstrap'], function(angular) {
	console.log("::: app.js define :::");
	var app = angular.module('abtest.admin', ['ui.bootstrap'], function(){
		
	});
	
	app.init = function(){
		console.log('=== called function init()');
		angular.bootstrap(document, [ 'abtest.admin' ]);
	};
	
	return app;
});