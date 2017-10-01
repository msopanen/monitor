(function(global){
	require(['require','jquery','jg'], function (rjs,$,JG) {
	
		
		var gauges = {},
			i = 0;
		
		createGauge = function(id,value,title,label,min,max) {
			if(gauges[id] === undefined) {
				
				var width = 0.7 * $(window).width(),
					height = 0.8 * width;
				
				$('#gauges').append('<div id="gauge' + ++i +'"></div>');
				$('#gauge' + i).width(width);
				$('#gauge' + i).height(height);
				$('#gauge' + i).css("margin","0px auto 0px auto");
				
				gauges[id] = new JG({
		    	    id: "gauge" + i,
		    	    value: value,
		    	    min: min,
		    	    max: max,
		    	    title: title,
		    	    label: label
		    	});
			}
			
			return gauges[id];
		};
		
		refresh = function() {
	  		$.getJSON( "rest/temperature/list", function(data) {		
				
				$.each(data, function(k,v){
					
					console.log(v.id + ' ' + v.value);
					
					var g = createGauge(v.id,v.value,v.title,v.label,v.min,v.max);
					
					g.refresh(parseInt(v.value)/1000);
				});
			});
		};
		
	    $(function() {	    	
	    	
	    	setInterval(function(){
	    		refresh();
	    	}, 2000);

	    });
	});
})(this);