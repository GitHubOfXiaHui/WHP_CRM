$(function(){
	var menuBtn = $('.left_menu>h3>span');
	//alert(menuBtn.length);
	menuBtn.click(function(){
		$(this).parent('h3').siblings('ul').slideUp(400);
		$(this).parent('h3').next('ul').slideDown(400);
	});
	
	var subMenuBtn = $('.left_menu>ul>li');
//	alert(subMenuBtn.length);
	subMenuBtn.click(function(){
		$(this).children('a').addClass('left_menu_current2').end().siblings('li').children('a').removeClass();
		$(this).children('ol').slideDown(400).end().siblings('li').children('ol').slideUp(400);
	});
});