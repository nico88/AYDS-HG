	function json2html(json) {
		var i, ret = document.createElement('ul'), li;
		for( i in json) {
			li = ret.appendChild(document.createElement('li'));
			li.appendChild(document.createTextNode(i+": "));
			if( typeof json[i] === "object") li.appendChild(json2html(json[i]));
			else li.firstChild.nodeValue += json[i];
		}
		return ret;
	}			
	
	$(document).ready(function () {
		$('h1').addClass('ui-widget ui-widget-header ui-accordion-header ui-helper-reset ui-state-default ui-corner-all ui-helper-clearfix');
		$('#tabs').tabs().addClass( "ui-tabs-vertical ui-helper-clearfix" );
		$('#tabs .ui-tabs-nav ').tabs().addClass( "ui-corner-tl ui-corner-bl" );
		$('#tabs .ui-tabs-nav').tabs().removeClass( "ui-corner-all" );
		$( "#tabs li" ).removeClass( "ui-corner-top" ).addClass( "ui-corner-left" );
		
		$("form input[type=submit]").button();
		$("form input[type=text]").addClass('ui-widget ui-corner-all');
	
		$("form").submit(function(e){
			e.preventDefault();
			var form = $(e.currentTarget)
			
			$.ajax({
				url: "http://localhost:4567"+form.attr("action"),
				type: form.attr("method").toUpperCase(),
				data: form.serialize(),
				jsonpCallback: 'jsonCallback',
				contentType: "application/json",
				dataType: 'jsonp',
				success: function(json) {
				   $('.resoult',form.parent()).html(json2html(json));
				},
				error: function(e) {
				   console.log(e.message);
				}
			});
		}); //--form submit
		
	});

