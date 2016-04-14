'use strict';
console.log('### postTest.js ###');

define(['app'], function(app) {
	console.log('= [controller/postTest.js] define_callback');
	
	app.controller('PostTestController', function($scope, $http) {
		console.log('= [controller/temp.js] PostTestController_callback');
		
		$scope.onClickSubmit = function() {
			console.log('onClickSubmit!' + $scope.object.value);
			
			var result = $http.post('/board/postTest', $scope.object, {
				headers: { 'Content-Type': 'application/json; charset=UTF-8'}
		    });			
			result.success(function(res) {
				alert("저장 성공!");
				console.log('... saveDataToDB success ', res);
			});
			result.error(function(res) {
				alert("헉 오류 발생");
				console.log('... saveDataToDB err ', res);
			});
		}

	})
	
});