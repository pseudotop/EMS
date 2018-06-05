package app;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class TempLineChart extends ApplicationFrame {

	public TempLineChart(String applicationTitle, String chartTitle) {
		super(applicationTitle);
		JFreeChart lineChart = ChartFactory.createLineChart(chartTitle, "times", "Temperature", createDataset(),
				PlotOrientation.VERTICAL, true, true, false);
		
		ChartPanel chartPanel = new ChartPanel(lineChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
		setContentPane(chartPanel);
		
	}	

	private DefaultCategoryDataset createDataset() {
		String temp = "temperature";

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(15, temp, "10:30");
		dataset.addValue(17, temp, "10:31");
		dataset.addValue(18, temp, "10:32");
		dataset.addValue(20, temp, "10:33");
		dataset.addValue(22, temp, "10:34");
		dataset.addValue(23, temp, "10:35");
		dataset.addValue(22, temp, "10:36");
		dataset.addValue(20, temp, "10:37");
		dataset.addValue(18, temp, "10:38");
		dataset.addValue(16, temp, "10:39");

		return dataset;
	}


}
