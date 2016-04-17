'use strict';
console.log('### listCri.js ###');

define(['app'], function(app) {
	console.log('= [controller/listCri.js] define_callback');
	
	app.controller('ListCriController', function($scope, $location, $http, $window) {
		console.log('= [controller/listCri.js] ListCriController_callback');
		
		$scope.showPagination = false;
		
		var urlParam = $location.search();
		
		if (!!urlParam && !!urlParam.page && !!urlParam.perPageNum) {
			$scope.page = urlParam.page;
			$scope.perPageNum = urlParam.perPageNum;
		} else {
			$scope.page = 1;
			$scope.perPageNum = 10;
		}
		
		// Search Result
		if (!!urlParam && !!urlParam.searchType && !!urlParam.keyword) {
			$scope.searchKeywordType = urlParam.searchType;
			$scope.searchKeyword = urlParam.keyword;
		}
		
		var requestBookList = function(page, perPageNum) {
			var requestUrl;
			if (!$scope.searchKeyword) { 
				requestUrl = '/board/listPage?page=' + page + '&perPageNum=' + perPageNum;
			} else {
				requestUrl = '/sboard/list?page=' + page + '&perPageNum=' + perPageNum +
							'&searchType=' + $scope.searchKeywordType + '&keyword=' + $scope.searchKeyword;
			}
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
		
		$scope.onClickSearchButton = function() {
			console.log('onClickSearchButton : ' + $scope.searchKeyword);
			var host = $location.protocol() + '://' + location.host + "/";
			$window.location.href = host + 'html/index.html#!/listCri?' + 
						'page=' + $scope.currentPage + '&perPageNum=' + $scope.perPageNum +
						'&searchType=' + $scope.searchKeywordType + '&keyword=' + $scope.searchKeyword;
		}
		
		$scope.searchKeywordTypeList = ['Title', 'Writer', 'Title And Writer'];
		if (!$scope.searchKeywordType) {
			$scope.searchKeywordType = $scope.searchKeywordTypeList[0];
		}
		$scope.onClickSearchKeywordType = function(searchKeywordType) {
			$scope.searchKeywordType = searchKeywordType;
		}
	})
	
});