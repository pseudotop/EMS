package app;

import javax.swing.JDialog;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class InnerDustLineChart extends JDialog {

	public InnerDustLineChart(String applicationTitle, String chartTitle) {
		//super(applicationTitle);
		JFreeChart lineChart = ChartFactory.createLineChart(chartTitle, "times", "InnerDustLineChart", createDataset(),
				PlotOrientation.VERTICAL, true, true, false);
		
		ChartPanel chartPanel = new ChartPanel(lineChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
		setContentPane(chartPanel);
		
	}	

	private DefaultCategoryDataset createDataset() {
		String innerDust = "innerDust";

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(100, innerDust, "10:30");
		dataset.addValue(80, innerDust, "10:31");
		dataset.addValue(70, innerDust, "10:32");
		dataset.addValue(75, innerDust, "10:33");
		dataset.addValue(50, innerDust, "10:34");
		dataset.addValue(43, innerDust, "10:35");
		dataset.addValue(42, innerDust, "10:36");
		dataset.addValue(42, innerDust, "10:37");
		dataset.addValue(50, innerDust, "10:38");
		dataset.addValue(55, innerDust, "10:39");

		return dataset;
	}


}
