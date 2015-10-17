describe('service: restService: get', function() {
  describe('when the get method is called', function() {
    var restService;
    var $httpBackend;

    var root = '/api';
    var path = '/path';

    beforeEach(module("skyExerciseApp"));

    beforeEach(inject(function(_$httpBackend_, _restService_) {
        $httpBackend = _$httpBackend_;
        restService = _restService_;
    }));

    afterEach(function(){
        $httpBackend.flush();
        $httpBackend.verifyNoOutstandingExpectation();
        $httpBackend.verifyNoOutstandingRequest();
    });

    it('should make a get rest call with the correct path', function() {

        $httpBackend.expectGET(root + path).respond({status: 'OK'});

        restService.get(path);
    });
  });
});
