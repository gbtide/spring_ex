'use strict';
console.log('### listAll.js ###');

define(['app'], function(app) {
	console.log('= [controller/listAll.js] define_callback');
	
	app.controller('ListAllController', function($scope, $location) {
		console.log('= [controller/listAll.js] ListAllController_callback');
		console.log('... result? = ', $location.search());
		
		var searchResult = $location.search();
		if (!!searchResult && searchResult.result == 'SUCCESS') {
			alert('SUCCESS!');
		}
	})
	
});