describe('skyExerciseApp: config', function() {

	var $route, $location, $rootScope, $httpBackend;

    beforeEach(module('skyExerciseApp'));

    beforeEach(inject(function(_$rootScope_, _$route_, _$location_, _$httpBackend_) {
    	$route = _$route_;
    	$rootScope = _$rootScope_;
    	$location = _$location_;
    	$httpBackend = _$httpBackend_;
    }));

    afterEach(function() {
        $httpBackend.verifyNoOutstandingExpectation();
        $httpBackend.verifyNoOutstandingRequest();
    });

    describe('when the "/" route is chosen', function() {

        	it('should navigate to the product selection page', function() {

        		$httpBackend.expectGET('/pages/productSelection.html').respond(200);//mimicking the AJAX call

        		expect($route.current).toBeUndefined();
    		    $location.path('/');
    		    $rootScope.$digest();

    		    $httpBackend.flush();

    		    expect($route.current.templateUrl).toBe('/pages/productSelection.html');
    		    expect($route.current.controller).toBe('productSelectionCtrl');

            });
        });

    describe('when the "/checkout" route is chosen', function() {

    	it('should navigate to the confirmation page', function() {

    		$httpBackend.expectGET('/pages/confirmation.html').respond(200);

    		expect($route.current).toBeUndefined();
		    $location.path('/checkout');
		    $rootScope.$digest();

		    $httpBackend.flush();

		    expect($route.current.templateUrl).toBe('/pages/confirmation.html');
		    expect($route.current.controller).toBe('confirmationCtrl');

        });
    });
});