$(document).ready(function(){
	 $(window).scroll(function () {
		 if($(window).width() > 700){
	        if ($(this).scrollTop() > 100) {
	            $('.scrollup').fadeIn();
	        } else {
	            $('.scrollup').fadeOut();
	        }
		 }
	    });

	    $('.scrollup').click(function () {
	        $("html, body").animate({
	            scrollTop: 0
	        }, 600);
	        return false;
	    });
})