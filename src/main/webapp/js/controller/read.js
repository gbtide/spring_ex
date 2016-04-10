'use strict';
console.log('### read.js ###');

define(['app'], function(app) {
	console.log('= [controller/read.js] define_callback');
	
	app.controller('ReadController', function($scope, $location, $http, $window) {
		console.log('= [controller/read.js] ReadController_callback');
		console.log('... result? = ', $location.search());
		
		var bno;		
		var searchResult = $location.search();
		if (!!searchResult && !!searchResult.bno) {
			bno = searchResult.bno;
		}
		
		var requestBookInfo = function(bno) {
			var requestUrl = '/board/read?bno=' + bno;
			var result = $http.get(requestUrl);
			
			result.success(function(res) {
				if (!res || res.code != 0) {
					alert('response err : ' + res.message);
					return;
				}
				$scope.book = res.item;
			});
			result.error(function(res) {
				alert('result err : ' + res.message);
			});
		}
		
		requestBookInfo(bno);
		
		$scope.onClickModify = function(bno) {
			console.log('called onClickModify : ' + bno);
		}
		
		$scope.onClickDelete = function(bno) {
			console.log('called onClickDelete : ' + bno);
			
			var result = confirm();
			if (!result) {
				return;
			}
			var requestUrl = '/board/remove?bno=' + bno;
			var result = $http.get(requestUrl);
			
			result.success(function(res) {
				backToList();
			});
			result.error(function(res) {
				alert('result err : ' + res.message);
			});
		}
		
		$scope.onClickGoToList = function() {
			console.log('called onClickGoToList');
			backToList();
		}
		
		var backToList = function() {
			$window.location.href = '#!/listAll';
		}
	})
	
});