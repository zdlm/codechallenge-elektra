'use strict';

var _ = require("lodash");

module.exports = function ($scope, $http, socket) {

    socket.on('newMessage', function (item) {
        $scope.getData();
    });

    $scope.getData = function () {
        $http.get('/api/message').
            success(function (data, status, headers, config) {
                $scope.messages = _(data.messages).reverse().value();
            });
    };

    $scope.postData = function () {
        if (!$scope.content) {
            return;
        }
        $http.post('/api/message', {content: $scope.content})
            .success(function (data, status, headers, config) {
                $scope.content = "";
            });
    };

    $scope.getData();

};