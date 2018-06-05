import java.util.ArrayList;

public class GoogleAPI {
	public String getChart(ArrayList<Emplements> list) {
		String htmlString = "<html>\r\n" + 
				"  <head>\r\n" + 
				"    <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\r\n" + 
				"    <script type=\"text/javascript\">\r\n" + 
				"      google.charts.load('current', {'packages':['corechart']});\r\n" + 
				"      google.charts.setOnLoadCallback(drawChart);\r\n" + 
				"      function drawChart() {\r\n" + 
				"        var data = google.visualization.arrayToDataTable([\r\n" + 
				"          ['�ð�', '�µ�', '����'],\r\n";
				for(int i = 0 ; i<list.size();i++) {
					htmlString += "['"+list.get(i).getDate()+"',"+list.get(i).getTemp()+", "+list.get(i).getHumidity()+"],\r\n";
				}
				htmlString += "        ]);\r\n" + 
				"        var options = {\r\n" + 
				"          title: '���ǽ� ��Ȳ',\r\n" + 
				"          hAxis: {title: '�ð�',  titleTextStyle: {color: '#333'}},\r\n" + 
				"          vAxis: {minValue: 0}\r\n" + 
				"        };\r\n" + 
				"        var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));\r\n" + 
				"        chart.draw(data, options);\r\n" + 
				"      }\r\n" + 
				"    </script>\r\n" + 
				"  </head>\r\n" + 
				"  <body>\r\n" + 
				"    <div id=\"chart_div\" style=\"width: 100%; height: 500px;\"></div>\r\n" + 
				"  </body>\r\n" + 
				"</html>";
		
		return htmlString;
	}
}
