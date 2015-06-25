'use strict';

module.exports = function($http) {
	return {
        getData: function(url){
            if(!url){
                return null;
            }
            return $http.get(url);
        },
        postData: function(url, content){
            if(!url || !content){
                return null;
            }
                return $http.post(url, {content: content});
        }

    }
};