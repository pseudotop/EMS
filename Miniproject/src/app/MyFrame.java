package app;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.ui.RefineryUtilities;

import thread.ThreadTask;

public class MyFrame extends JFrame{
	public static JLabel tempText, humidityText, innerDustText, outerDustText;
	JPanel allPanel, p1, p2, p3, p4;
	JButton tempBtn, humidityBtn, innerDustBtn, outerDustBtn;

	JLabel tempLabel,humidityLabel,innerDustLabel,outerDustLabel;

	public MyFrame() {
		setSize(400, 200);	
		
		setTitle("강의실 환경 관리 시스템");

		allPanel = new JPanel(new GridLayout(4, 3));

		tempLabel = new JLabel("온도");
		tempLabel.setSize(100,300 );
		tempText = new JLabel();
		tempText.setText("0");

		tempBtn = new JButton("온도 변화");
		tempBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				TempLineChart chart = new TempLineChart("온도 변화", ThreadTask.list.get(0).getRegtime().substring(0,10)+" Temperature");
				
				chart.pack();
				RefineryUtilities.centerFrameOnScreen(chart);
				chart.setVisible(true);
				
			}
		});

		allPanel.add(tempLabel);
		allPanel.add(tempText);
		allPanel.add(tempBtn);
    
		humidityLabel = new JLabel("습도");
		humidityText = new JLabel();
		humidityText.setText("0");
		humidityBtn = new JButton("습도 변화");
		humidityBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				HumidityLineChart chart = new HumidityLineChart("습도 변화", ThreadTask.list.get(0).getRegtime().substring(0,10)+" Humidity");

				chart.pack();
				RefineryUtilities.centerFrameOnScreen(chart);
				chart.setVisible(true);
				
			}
		});
    
		allPanel.add(humidityLabel);
		allPanel.add(humidityText);
		allPanel.add(humidityBtn);

		innerDustLabel = new JLabel("실내먼지");
		innerDustText = new JLabel();
		innerDustText.setText("0");
		innerDustBtn = new JButton("실외 먼지 변화");
		
		innerDustBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				InnerDustLineChart chart = new InnerDustLineChart("실내 미세먼지 변화", ThreadTask.list.get(0).getRegtime().substring(0,10)+" InnerDust");

				chart.pack();
				RefineryUtilities.centerFrameOnScreen(chart);
				chart.setVisible(true);
				
			}
		});

		allPanel.add(innerDustLabel);
		allPanel.add(innerDustText);
		allPanel.add(innerDustBtn);

		outerDustLabel = new JLabel("실외먼지");
		outerDustText = new JLabel();
		outerDustText.setText("0");
		outerDustBtn = new JButton("실외 먼지 변화");
		
		outerDustBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				OuterDustLineChart chart = new OuterDustLineChart("실외 미세먼지 변화", ThreadTask.list.get(0).getRegtime().substring(0,10)+" OuterDust");

				chart.pack();
				RefineryUtilities.centerFrameOnScreen(chart);
				chart.setVisible(true);
				
			}
		});

		allPanel.add(outerDustLabel);
		allPanel.add(outerDustText);
		allPanel.add(outerDustBtn);

		add(allPanel);
		setVisible(true);
	}
}
