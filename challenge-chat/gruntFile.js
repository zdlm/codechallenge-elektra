module.exports = function(grunt) {
  grunt.loadNpmTasks('grunt-browserify');
 
  grunt.registerTask('default', ['browserify']);
 
  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
    browserify: {
      main: {
        src: './public/javascripts/app.js',
        dest: './public/javascripts/main.js'
      }
    }
  });
}