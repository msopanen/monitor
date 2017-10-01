requirejs.config({
    baseUrl: '.',
    paths: {
    	require: 		'node_modules/requirejs/require',
        jquery: 		'node_modules/jquery/dist/jquery',
        eve:            'node_modules/raphael/node_modules/eve/eve',
        raphaelcore:    'node_modules/raphael/dev/raphael.core',
        raphaelsvg:     'node_modules/raphael/dev/raphael.svg',
        raphaelvml:     'node_modules/raphael/dev/raphael.vml',
        raphael:        'node_modules/raphael/dev/raphael.amd',
        justgage:       'node_modules/justgage/justgage',
        jg:             'app/scripts/jg'
    },
    shim: {
        'justgage': {
            deps: ['eve','raphael'],
            exports: 'JustGage'
        }
    }
});