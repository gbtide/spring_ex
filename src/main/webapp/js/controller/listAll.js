'use strict';
console.log('### listAll.js ###');

define(['app'], function(app) {
	console.log('= [controller/listAll.js] define_callback');
	
	app.controller('ListAllController', function($scope, $location, $http) {
		console.log('= [controller/listAll.js] ListAllController_callback');
		console.log('... result? = ', $location.search());
		
		var searchResult = $location.search();
		if (!!searchResult && searchResult.result == 'SUCCESS') {
			alert('SUCCESS!');
		}
		
		var requestBookList = function() {
			var requestUrl = '/board/listAll';
			var result = $http.get(requestUrl);
			
			result.success(function(res) {
				if (!res || res.code != 0) {
					alert('response err : ' + res.message);
					return;
				}
				$scope.bookList = res.list;
				console.log('$scope.bookList : ', $scope.bookList);
			});
			result.error(function(res) {
				alert('result err : ' + res.message);
			});
		}
		
		requestBookList();
	})
	
});