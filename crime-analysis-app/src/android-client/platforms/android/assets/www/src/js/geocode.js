function geoCode(address)
{
	$( "#search_result" ).empty();
	$('#search_result_container').show();
	$.getJSON("https://maps.googleapis.com/maps/api/geocode/json?address="+address, null, function(res)      
    {    
      

    	 if(res['results'][0])
    	 {
   	     	for(count=0;count<res['results'].length;count++)
   	     	{

   	     		$( "#search_result" ).append('<input type=\"radio\" name=\"target_address\" value=\"'+res['results'][count]['geometry']['location']['lat']+'#'+res['results'][count]['geometry']['location']['lng']+'\">&nbsp;&nbsp;'+res['results'][count]['formatted_address']+'<br><br>');
         	}
         	$( "#search_result" ).append('<a href=\"analysis.html\"> <input type=\"button\" name=\"go\" id=\"go\" value=\"Go\" > </a>');
         	$( "#search_result" ).append('<input type=\"button\" name=\"clear_search\" id=\"clear_search\" value=\" Clear\" onclick="clearSearchResult()">');

         	$('#search_form_container').hide();
         }
         else
         {
         		$( "#search_result" ).append('<font color=\"#FA5858\">No Result.Please check your address.</font>');
         }

    });
	
}


