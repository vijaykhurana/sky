describe('controller: productSelectionCtrl: updateBasket', function() {
  var $scope, $controller, storageService, restService, $q, categories;

  beforeEach(module("skyExerciseApp"));
        beforeEach(inject(function($rootScope, _storageService_, _restService_,  _$controller_, _$q_) {
          $scope = $rootScope.$new();
          $controller =_$controller_;
          storageService = _storageService_;
          restService = _restService_;
          $q = _$q_;
          categories = "{'NEWS': ['Sky News']}";

          spyOn(storageService, 'set').andCallThrough();
          spyOn(restService, 'get').andCallFake(function() {
              var deferred = $q.defer();
              deferred.resolve(categories);
              return deferred.promise;
          });

          $controller('productSelectionCtrl', {
              '$scope': $scope,
              'storageService': storageService,
              'restService': restService
          });

        }));

  describe('when the user checks or unchecks a product checkbox on the product selection page', function() {
      it('should add product to basket when the checkbox is checked', function() {
            var productName = 'Arsenal TV';

            $scope.updateBasket(productName);

            expect($scope.basket.length).toBe(1);
            expect($scope.basket[0]).toBe(productName);
      })

      it('should remove product from basket when the checkbox is unchecked', function() {
            var productName = 'Chelsea TV';

            $scope.updateBasket(productName);
            $scope.updateBasket(productName);

            expect($scope.basket.length).toBe(0);
      })
   });

   describe('when the user checks multiple products on the product selection page', function() {
      it('should add multiple products to the basket', function() {
          var productName1 = 'Chelsea TV';
          var productName2 = 'Arsenal TV'

          $scope.updateBasket(productName1);
          $scope.updateBasket(productName2);

          expect($scope.basket.length).toBe(2);
          expect($scope.basket[0]).toBe(productName1);
          expect($scope.basket[1]).toBe(productName2);
    })
   });

   describe('when the updateBasket method is called', function() {
      it('should make a get rest call using the rest service and store result to scope', function() {
          $scope.$digest();
          expect($scope.categories).toBe(categories) ;
      })
   });

 });

