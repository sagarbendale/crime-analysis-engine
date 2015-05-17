<html>
  <head>
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript" src="src/js/jquery.js"></script>
     <script type="text/javascript" src="src/js/charts.js"></script>
    <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(load_page_data);
      function load_page_data()
      {
			$.getJSON("rest/analysis/byDay", null, function(x) 		
			{
					drawCrimeByDay(x);			
			});
			
			$.getJSON("rest/analysis/byDay", null, function(x) 		
			{
							drawCrimeByDay2(x);			
			});
			
    	}
      

    

      
      
    </script>
  </head>
  <body>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
     <div id="piechart2" style="width: 900px; height: 500px;"></div>
  </body>
</html>
