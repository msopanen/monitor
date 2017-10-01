var gulp = require('gulp'),
  l10n = require('gulp-l10n');
	concat = require('gulp-concat');

gulp.task("bundle-js", function () {
  var amdOptimize = require('amd-optimize'),
  	  uglify = require('gulp-uglify');
  
  return amdOptimize.src('app/scripts/main', {
    	  configFile : 'require.config.js'
    })
    .pipe(concat('main.min.js'))
    //.pipe(uglify())
    .pipe(gulp.dest('dist/scripts'));
});

gulp.task('copy-html', function() {
  return gulp.src('app/**/*.html')
    .pipe(gulp.dest('dist/en'));
});

gulp.task('extract-locales', function () {
  return gulp.src('app/**/*.html')
    .pipe(l10n.extract())
    .pipe(gulp.dest('locales'));
});

gulp.task('load-locales', ['extract-locales'], function () {
  return gulp.src('locales/*.json')
    .pipe(l10n.setLocales({
      native: 'en',
      enforce: 'warn'
    }));
});
 
gulp.task('localize', ['load-locales'], function () {
  return gulp.src('app/**/*.html')
    .pipe(l10n())
    .pipe(gulp.dest('dist'));
});

gulp.task('build', ['localize','bundle-js','copy-html']);

gulp.task('clean', function () {
  var clean = require('gulp-clean');
  return gulp.src('dist', {read: false})
    .pipe(clean());
});

gulp.task('webserver', function() {
  var webserver = require('gulp-webserver');
  return gulp.src('dist')
    .pipe(webserver({
      fallback: 'en/widget.html'
    }));
});