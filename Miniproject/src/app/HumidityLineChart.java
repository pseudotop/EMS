package app;

import javax.swing.JDialog;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class HumidityLineChart extends JDialog {

	public HumidityLineChart(String applicationTitle, String chartTitle) {
		//super(applicationTitle);
		JFreeChart lineChart = ChartFactory.createLineChart(chartTitle, "times", "humidity", createDataset(),
				PlotOrientation.VERTICAL, true, true, false);
		
		ChartPanel chartPanel = new ChartPanel(lineChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
		setContentPane(chartPanel);
	}

	private DefaultCategoryDataset createDataset() {
		String humidity = "humidity";

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(43, humidity, "10:30");
		dataset.addValue(42, humidity, "10:31");
		dataset.addValue(40, humidity, "10:32");
		dataset.addValue(45, humidity, "10:33");
		dataset.addValue(60, humidity, "10:34");
		dataset.addValue(67, humidity, "10:35");
		dataset.addValue(69, humidity, "10:36");
		dataset.addValue(65, humidity, "10:37");
		dataset.addValue(61, humidity, "10:38");
		dataset.addValue(50, humidity, "10:39");

		return dataset;
	}


}
