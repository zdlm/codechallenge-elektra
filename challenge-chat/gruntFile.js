module.exports = function(grunt) {
  grunt.loadNpmTasks('grunt-browserify');
  grunt.loadNpmTasks("grunt-jasmine-node");

  grunt.registerTask('test',["jasmine_node"]);
 
  grunt.registerTask('default', ['browserify',"jasmine_node"]);
 
  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
    browserify: {
      main: {
        src: './public/javascripts/app.js',
        dest: './public/javascripts/main.js'
      }
    },
    jasmine_node: {
      options: {
        forceExit: true,
        match: '.',
        matchall: false,
        extensions: 'js',
        specNameMatcher: 'spec'
      },
      all: ['spec/']
    }
  });
}