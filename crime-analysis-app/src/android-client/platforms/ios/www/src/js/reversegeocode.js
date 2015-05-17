function reverseGeocode(lat,lon) 
{
    $( "#search_result" ).empty();
    $('#search_result_container').show();
  	$.getJSON("http://maps.google.com/maps/api/geocode/json?latlng="+lat+","+lon+"&sensor=false", null, function(res)      
    {

    	if(res['results'][0])
    	 {
            
   	     	$( "#search_result" ).append('<input type=\"radio\" checked name=\"target_address\" value=\"'+lat+'#'+lon+'\">&nbsp;&nbsp;'+res['results'][0]['formatted_address']+'<br><br>');
         	
            $( "#search_result" ).append('<a href=\"analysis.html\"> <input type=\"button\" name=\"go\" id=\"go\" value=\"Go\" > </a>');
         	$( "#search_result" ).append('<input type=\"button\" name=\"clear_search\" id=\"clear_search\" value=\" Clear\" onclick="clearSearchResult()">');
         	$('#search_form_container').hide();
            
         	plotLocation(lat,lon)
       
        }
        else
        {
         	$( "#search_result" ).append('<font color=\"#FA5858\">No Result.Please check your address.</font>');
        }
        
     });

}



