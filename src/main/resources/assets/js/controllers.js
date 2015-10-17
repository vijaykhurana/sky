'use strict';

/* Controllers */
var controllers = angular.module('skyExerciseApp.controllers', []);

controllers.controller('productSelectionCtrl', function($scope, $http, storageService, restService) {
	$scope.basket = [];
	$scope.updateBasket = function (productName) {
       var idx = $scope.basket.indexOf(productName);

       if (idx > -1) {
         $scope.basket.splice(idx, 1);
       }
       else {
      	 $scope.basket.push(productName);
       }

       storageService.set('selectedProducts', $scope.basket);
    }

    // the customer id would be passed from the cookie. Assume now it is 1
    restService.get("/customer/1/products").then(function(result) {
        $scope.categories = result;
    });

});

controllers.controller('confirmationCtrl', function($scope, storageService) {
    $scope.subscribedProducts = storageService.get('selectedProducts');
});
