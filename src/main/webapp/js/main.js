'use strict';

requirejs.config({
	paths : {
		'jquery' : '/vendor/jquery/dist/jquery.min',

		'angular' : '/vendor/angular/angular.min',
		'angular-animate' : '/vendor/angular-animate/angular-animate.min',
		'angular-route' : '/vendor/angular-route/angular-route.min',
		'angular-sanitize' : '/vendor/angular-sanitize/angular-sanitize.min',
		
		'bootstrap' : '/vendor/bootstrap/dist/js/bootstrap.min',
		'angular-bootstrap' : "/vendor/angular-bootstrap/ui-bootstrap.min",
		
		'Chart' : '/vendor/Chart.js/Chart.mins',
		'angular-chart' : '/vendor/angular-chart.js/angular-chart',

		'moment': '/vendor/moment/min/moment-with-locales.min',
		'angular-bootstrap-datetimepicker': '/vendor/angular-bootstrap-datetimepicker/src/js/datetimepicker',
		
		'ngToast' : '/vendor/ngtoast/dist/ngToast.min',

		'requirejs-domReady' : '/vendor/requirejs-domready/domReady',
		'requirejs-text' : '/vendor/requirejs-text/text'
	},
	shim : {
		'angular' : {
			deps : ['jquery'],
			exports : 'angular'
		},
		'bootstrap' : {
			deps: ['jquery']
		},
		'angular-animate' : {
			deps : ['angular']
		},
		'angular-route' : {
			deps : ['angular']
		},
		'angular-bootstrap' : {
			deps : ['angular', 'bootstrap', 'angular-animate']
		},
		'ngToast' : {
			deps : ['angular-sanitize', 'angular-animate']
		}
	}
});

// app. route의 경우, baseUrl(따로 설정하지 않았으면, main.js folder path)을 기준으로 js파일을 가져옴.)
requirejs(['requirejs-domReady', 'app', 'route'], function(domReady, app) {
	domReady(function() {
		console.log('= [main.js] domReady_callback');
		app.init();
	});

});