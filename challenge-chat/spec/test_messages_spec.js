
var socket = require("../public/javascripts/service/socket")();
var $scope = {
    getData: function () {
    },
    postData: function () {
    },
    content: "test"
};
var $http = {
    get:function(){},
    post:function(){}
};
var controller = require("../public/javascripts/controller/messages");

describe("client side controller test", function () {
    describe("called test", function () {
        beforeEach(function () {
            spyOn(socket, "on").andCallFake(function () {

            });
            spyOn($http, "get").andCallFake(function () {
                return {
                    success:function(callback){
                        callback({"messageCount":1,"lastMessage":"2015-07-03T11:41:35.784Z","messages":[{"message":{"content":"hello test"}}]},null,null,null);
                }};
            });
            spyOn($http, "post").andCallFake(function () {
                return {
                    success:function(callback){
                        callback({"result":"ok"},null,null,null)
                    }};
            });
            controller($scope, $http, socket);
        });

        it("tracks that the operation.getData was called", function () {
            $scope.getData();
            expect($scope.messages).toEqual([{"message":{"content":"hello test"}}]);
        });

        it("tracks that the operation.postData was called", function () {
            $scope.postData();
            expect($scope.content).toEqual("");
        });
    });

});

