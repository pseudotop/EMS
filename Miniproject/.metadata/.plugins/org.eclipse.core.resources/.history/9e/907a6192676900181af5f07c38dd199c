package app;

import javax.swing.JDialog;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class OuterDustLineChart extends JDialog {

	public OuterDustLineChart(String applicationTitle, String chartTitle) {
		//super(applicationTitle);
		JFreeChart lineChart = ChartFactory.createLineChart(chartTitle, "times", "OuterDustLineChart", createDataset(),
				PlotOrientation.VERTICAL, true, true, false);
		
		ChartPanel chartPanel = new ChartPanel(lineChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
		setContentPane(chartPanel);
		
	}	

	private DefaultCategoryDataset createDataset() {
		String outerDust = "outerDust";

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(120, outerDust, "10:30");
		dataset.addValue(130, outerDust, "10:31");
		dataset.addValue(135, outerDust, "10:32");
		dataset.addValue(150, outerDust, "10:33");
		dataset.addValue(160, outerDust, "10:34");
		dataset.addValue(132, outerDust, "10:35");
		dataset.addValue(131, outerDust, "10:36");
		dataset.addValue(112, outerDust, "10:37");
		dataset.addValue(100, outerDust, "10:38");
		dataset.addValue(76, outerDust, "10:39");

		return dataset;
	}


}
