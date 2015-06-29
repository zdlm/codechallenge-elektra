var operation = require("../public/javascripts/service/operation")();
var socket = require("../public/javascripts/service/socket")();
var $scope = {
        		getData:function(){},
        		postData:function(){},
        		content:"test"
        	};
var controller = require("../public/javascripts/controller/messages");

describe("client side controller test", function(){
    describe("called test", function(){
        beforeEach(function() {
        	spyOn(socket, "on").andCallFake(function() {
        		
		    });
		    spyOn(operation, "getData").andCallFake(function() {
        		return {
        			success:function(data, status, headers, config){
        			}
        		};
		    });
		    spyOn(operation, "postData").andCallFake(function() {
        		return {
        			success:function(data, status, headers, config){
        			}
        		};
		    });
            controller($scope, operation, socket);
            $scope.getData();
            $scope.postData();

        });

        it("tracks that the operation.getData was called", function() {
            expect(operation.getData).toHaveBeenCalled();
        });

        it("tracks that the operation.postData was called", function() {
            expect(operation.postData).toHaveBeenCalled();
        });
    });

});

