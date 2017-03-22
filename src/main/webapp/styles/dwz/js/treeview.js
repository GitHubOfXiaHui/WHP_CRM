/*!
 * jQuery JavaScript Library v1.4.2
 * http://jquery.com/
 *
 * Copyright 2010, John Resig
 * Dual licensed under the MIT or GPL Version 2 licenses.
 * http://jquery.org/license
 *
 * Includes Sizzle.js
 * http://sizzlejs.com/
 * Copyright 2010, The Dojo Foundation
 * Released under the MIT, BSD, and GPL Licenses.
 *
 * Date: Sat Feb 13 22:33:48 2010 -0500
 */

$(document).ready(function(){
	$('.xbjys .left_navtit').click(function() {
		$('.xbjys .menu_3').slideUp('fast');	
		$(this).next().slideDown('fast');
	});
	
	$(".xbjys .menu_bg").trigger('click');

	$(".xbjys").find(".left_navtit").click(function(){

	$(".xbjys").find(".left_navtit").filter(".menu_bg").removeClass("menu_bg");
	$(this).addClass("menu_bg");
	
	});


	$(".xbjys").find(".menu_3").find("span").hover(
		function(){
			$(this).addClass("hover-ltbg");
		},
		function(){
			$(this).removeClass("hover-ltbg");
		}
	);


	$(".tablist tr").each(function(i) {  
         var className = ["odd", "even"][i % 2];  
         $(this).addClass(className);  
         $(this).hover(  
             function() {  
                 $(this).removeClass(className);  
                 $(this).addClass("current");  
            },  
             function() {  
                 $(this).removeClass("current");  
                 $(this).addClass(className);  
             }  
         )  
    }); 

	$("a.clibox").click(function(){
		$(".inf_box").removeClass("none").show();
	});
	
	$(".son_list dd").hide().first().show();
	$(".son_list dt").first().children().children("em.partoggle").addClass("current");
	$(".son_list dt").click(function(){
		$(this).next("dd").slideToggle();
		$(this).children().children("em.partoggle").toggleClass("current");
	});
		
});

