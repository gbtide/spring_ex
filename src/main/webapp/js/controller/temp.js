'use strict';
console.log('### temp.js ###');

define(['app'], function(app) {
	console.log('= [controller/temp.js] define_callback');
	
	app.controller('TempController', function($scope) {
		console.log('= [controller/temp.js] TempController_callback');
	})
	
});