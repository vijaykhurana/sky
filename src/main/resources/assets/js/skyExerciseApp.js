'use strict';

/* skyExerciseApp Module */
var skyExerciseApp = angular.module('skyExerciseApp', ['ngRoute', 'skyExerciseApp.controllers', 'skyExerciseApp.services']);

// configuring routes
skyExerciseApp.config(function($routeProvider) {
        $routeProvider

            // route for the productSelection page
            .when('/', {
                templateUrl : '/pages/productSelection.html',
                controller  : 'productSelectionCtrl'
            })

            // route for the confirmation page
            .when('/checkout', {
                templateUrl : '/pages/confirmation.html',
                controller  : 'confirmationCtrl'
            })
});
