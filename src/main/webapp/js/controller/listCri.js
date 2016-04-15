'use strict';
console.log('### listCri.js ###');

define(['app'], function(app) {
	console.log('= [controller/listCri.js] define_callback');
	
	app.controller('ListCriController', function($scope, $location, $http, $window) {
		console.log('= [controller/listCri.js] ListCriController_callback');
		
		$scope.showPagination = false;
		
		var searchResult = $location.search();
		
		if (!!searchResult && !!searchResult.page && !!searchResult.perPageNum) {
			$scope.page = searchResult.page;
			$scope.perPageNum = searchResult.perPageNum;
		} else {
			$scope.page = 1;
			$scope.perPageNum = 10;
		}
		
		var requestBookList = function(page, perPageNum) {
			var requestUrl = '/abtest/list?page=' + page + '&perPageNum=' + perPageNum;
			var result = $http.get(requestUrl);
			
			result.success(function(res) {
				if (!res || res.code != 0) {
					console.log('response err : ' + res.message);
					return;
				}
				$scope.bookList = res.list;
				
				initPagination(res.pageMaker);
			});
			result.error(function(res) {
				alert('result err : ' + res.message);
			});
		}

		requestBookList($scope.page, $scope.perPageNum);
		
		var initPagination = function(pager) {
			$scope.maxSize = 3;
			
			console.log('==== pager.totalCount : ' + pager.totalCount);
			$scope.totalItems = pager.totalCount;
			console.log('==== $scope.page : ' + $scope.page);
			$scope.currentPage = $scope.page;
			$scope.itemsPerPage = $scope.perPageNum;

			$scope.pageChanged = function() {
				console.log('Page changed to: ' + $scope.currentPage);
				var host = $location.protocol() + '://' + location.host + "/";
				$window.location.href = host + 'html/index.html#!/listCri?' + 
							'page=' + $scope.currentPage + '&perPageNum=' + $scope.perPageNum;
			};

			$scope.showPagination = true;
		}
	})
	
});