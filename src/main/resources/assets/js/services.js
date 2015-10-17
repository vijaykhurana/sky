'use strict';

/* Services */
var services = angular.module('skyExerciseApp.services', ['ngResource']);

services.factory('storageService', function() {
 var data = {};

 function set(key, value) {
   data[key] = value;
 }
 function get(key) {
  return data[key];
 }

 return {
  set: set,
  get: get
 }

});

services.factory('restService',
    function($resource) {
		var root = '/api';
		var service = {};

		service.get = function(path) {
			return $resource(root + path).get().$promise;
		};

		return service;
});