describe('service: storageService', function() {
  describe('when the set method is called with the selected products', function() {

    beforeEach(module("skyExerciseApp"));

    var storageService;
    beforeEach(inject(function( _storageService_) {
        storageService = _storageService_;
    }));

    it('should be able to retrieve the selected products with the get method', function() {

        storageService.set("selectedProducts", "['Arsenal TV', 'Chelsea TV");

        expect(storageService.get("selectedProducts")).toBe("['Arsenal TV', 'Chelsea TV");
    });
  });
});
