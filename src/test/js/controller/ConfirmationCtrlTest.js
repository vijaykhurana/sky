describe('controller: confirmationCtrl: getSelectedProducts', function() {
  describe('when the getSelectedProducts is called', function() {

      beforeEach(module("skyExerciseApp"));

      beforeEach(inject(function($rootScope, _storageService_, _$controller_) {
            $scope = $rootScope.$new();
            $controller =_$controller_;
            storageService = _storageService_;

            var products = ['Arsenal TV', 'Chelsea TV'];
            storageService.set('selectedProducts', products);

            spyOn(storageService, 'get').andCallThrough();
            $controller('confirmationCtrl', {
              '$scope': $scope,
              'storageService': storageService
            });
      }));

      it('should retrieve selected products and add to the scope', function() {
            expect($scope.subscribedProducts.length).toBe(2);
      })
  });
});

