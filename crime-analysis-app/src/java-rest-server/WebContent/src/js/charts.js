function drawCrimeByDay(x) {

	var data = new google.visualization.DataTable();
	data.addColumn('string', 'Day of Week');
	data.addColumn('number', 'Count');
	for (count = 0; count < (x.length); count++) {
		data.addRow([ x[count].dayOfWeek, x[count].totalCount ]);
	}

	var options = {
		title : 'My Daily Activities'
	};

	var chart = new google.visualization.PieChart(document
			.getElementById('piechart'));

	chart.draw(data, options);
}


function drawCrimeByDay2(x) {

	var data = new google.visualization.DataTable();
	data.addColumn('string', 'Day of Week');
	data.addColumn('number', 'Count');
	for (count = 0; count < (x.length); count++) {
		data.addRow([ x[count].dayOfWeek, x[count].totalCount ]);
	}

	var options = {
		title : 'My Daily Activities'
	};

	var chart = new google.visualization.BarChart(document
			.getElementById('piechart2'));

	chart.draw(data, options);
}