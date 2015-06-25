'use strict';

var _ = require("lodash");

module.exports = function($scope, operation, socket) {

  socket.on('newMessage', function (item) {
    $scope.getData();
  });

  $scope.getData = function(){
    var fetch = operation.getData('/api/message');
    if(fetch){
        fetch.success(function(data, status, headers, config){
          $scope.messages = _(data.messages).reverse().value();
        });  
    }
    
  };

  $scope.postData = function(){
    if(!$scope.content){
      return;
    }
    var post = operation.postData('/api/message', $scope.content);
    if(post){
      post.success(function(data, status, headers, config){
        $scope.content = "";
      });
    }
  };

  $scope.getData();

};