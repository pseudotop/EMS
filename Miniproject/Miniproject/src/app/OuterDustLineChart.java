package app;

import javax.swing.JDialog;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import thread.ThreadTask;

public class OuterDustLineChart extends JDialog {

	public OuterDustLineChart(String applicationTitle, String chartTitle) {
		//super(applicationTitle);
		JFreeChart lineChart = ChartFactory.createLineChart(chartTitle, "times", "OuterDustLineChart", createDataset(),
				PlotOrientation.VERTICAL, true, true, false);
		
		ChartPanel chartPanel = new ChartPanel(lineChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(1000, 367));
		setContentPane(chartPanel);
		
	}	

	private DefaultCategoryDataset createDataset() {
		String outerDust = "outerDust";

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(int i=0;i<ThreadTask.list.size();i++) {
			dataset.addValue(ThreadTask.list.get(i).getOuterDust(), outerDust, ThreadTask.list.get(i).getRegtime().substring(11));
		}

		return dataset;
	}


}
