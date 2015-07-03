'use strict';

var io = require("socket.io-client");
var constants = require("../../../constants");

module.exports = function ($rootScope) {
    var socket = io.connect(constants.HOST);
    return {
        on: function (eventName, callback) {
            socket.on(eventName, function () {
                var args = arguments;
                $rootScope.$apply(function () {
                    callback.apply(socket, args);
                });
            });
        },
        emit: function (eventName, data, callback) {
            socket.emit(eventName, data, function () {
                var args = arguments;
                $rootScope.$apply(function () {
                    if (callback) {
                        callback.apply(socket, args);
                    }
                });
            })
        },
        off: function (eventName) {
            socket.removeAllListeners(eventName);
        }
    };
};