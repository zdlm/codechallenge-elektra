

var operation = require("../public/javascripts/service/operation")();

describe("client side operation service test", function(){

    describe("called test", function(){
        beforeEach(function() {
            spyOn(operation, 'getData');
            spyOn(operation, 'postData');
            operation.getData("api/message");
            operation.postData("api/message","test");
        });

        it("tracks that the operation was called", function() {
            expect(operation.getData).toHaveBeenCalled();
            expect(operation.postData).toHaveBeenCalled();
        });

        it("tracks that the operation was called with api/message", function() {
            expect(operation.getData).toHaveBeenCalledWith("api/message");
            expect(operation.postData).toHaveBeenCalledWith("api/message", "test");
        });
    });

});