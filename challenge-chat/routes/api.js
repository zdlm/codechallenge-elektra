var express = require('express');
var router = express.Router();
// var dataPath = require("../constants").PATHS;
var http = require('http');
var socketio = require("socket.io");

router.socket = null;
router.socketServer = function(server){
    router.io = socketio.listen(server);
};


//register routes
//all the routs should be prefixed with /api
router.get('/', function(req, res, next) {
  res.send('api coming');
});

router.route('/message')
    .post(function(req, res){
        if(!req.body.content){
            res.status(500).send('content should not be empty!');
        }
        var content = req.body.content;
        var options = {
            host:'192.168.59.103',
            path:'/messages/names/' + content,
            port:'8080',
            method:'POST'
        };
        var callback = function(response){
            var body = "";
            response.on('data',function(message){
                body += message;
            });
            response.on('end',function(){
                router.io.sockets.emit('newMessage',content);
                var parsed = JSON.parse(body);
                res.json({
                    data:parsed,
                    status: 'ok',
                    message: 'menssage created!'
                });
            });
        }
        http.request(options, callback).end();
    })
    .get(function(req,res){
        var options = {
            host:'192.168.59.103',
            path:'/messages/recent',
            port:'8080'
        };
        var callback = function(response){
            var body = "";
            response.on('data',function(message){
                body += message;
            });
            response.on('end',function(){
                var parsed = JSON.parse(body);
                res.json(parsed);
            });
        }
        http.request(options, callback).end();
        
    });

module.exports = router;