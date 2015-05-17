function drawCrimeByDay(x) {

	var data = new google.visualization.DataTable();
	data.addColumn('string', 'Day of Week');
	data.addColumn('number', 'Count');
	for (count = 0; count < (x.length); count++) {
		data.addRow([ x[count].dayOfWeek, x[count].totalCount ]);
	}

	var options = {
		title : 'Crime By Day'
	};

	var chart = new google.visualization.PieChart(document
			.getElementById('crime_by_day'));

	chart.draw(data, options);
}


function drawCrimeByTime(x) 
{

	var data = new google.visualization.DataTable();
	data.addColumn('string', 'Day of Week');
	data.addColumn('number', 'Count');
	for (count = 0; count < (x.length); count++) {
		data.addRow([ x[count].dayOfWeek, x[count].totalCount ]);
	}

	var options = {
		title : 'Crime By Time'
	};

	var chart = new google.visualization.LineChart(document
			.getElementById('crime_by_time'));

	chart.draw(data, options);
}


function drawCrimeByType(x) 
{

	var data = new google.visualization.DataTable();
	data.addColumn('string', 'Day of Week');
	data.addColumn('number', 'Count');
	for (count = 0; count < (x.length); count++) {
		data.addRow([ x[count].dayOfWeek, x[count].totalCount ]);
	}

	var options = {
		title : 'Crime By Type'
	};

	var chart = new google.visualization.BarChart(document
			.getElementById('crime_by_type'));

	chart.draw(data, options);
}


