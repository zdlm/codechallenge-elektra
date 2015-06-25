'use strict';
 
var angular = require('angular');

var app = angular.module('chat', []);

app.service('operation', require('./service/operation'));
app.service('socket', require('./service/socket'));
app.controller('listCtrl', require('./controller/messages'));

