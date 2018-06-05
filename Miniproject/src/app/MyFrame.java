package app;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.ui.RefineryUtilities;

public class MyFrame extends JFrame{
	JPanel allPanel, p1, p2, p3, p4;
	JButton tempBtn, humidityBtn, indoorDustBtn, outdoorDustBtn;
	JLabel tempText, humidityText, indoorDustText, outdoorDustText;

	public MyFrame() {
		setBackground(Color.GREEN);
		setSize(300, 200);	
		
		setTitle("강의실 환경 관리 시스템");

		allPanel = new JPanel(new FlowLayout());

		p1 = new JPanel(new GridLayout(1, 2));
		tempText = new JLabel();
		tempText.setText("온도");

		tempBtn = new JButton("온도 변화");
		tempBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				TempLineChart chart = new TempLineChart("온도 변화", "Temperature");

				chart.pack();
				RefineryUtilities.centerFrameOnScreen(chart);
				chart.setVisible(true);
				chart.addWindowListener(new WindowListener() {
					@Override
					public void windowClosing(WindowEvent arg0) {
						chart.setVisible(false);
					}

					@Override
					public void windowActivated(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowClosed(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowDeactivated(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowDeiconified(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowIconified(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowOpened(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
			}
		});
		p1.add(tempText);
		p1.add(tempBtn);

		allPanel.add(p1);

		p2 = new JPanel(new GridLayout(1, 2));
		humidityText = new JLabel();
		humidityText.setText("습도");
		humidityBtn = new JButton("습도 변화");
		humidityBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				HumidityLineChart chart = new HumidityLineChart("습도 변화", "Humidity");

				chart.pack();
				RefineryUtilities.centerFrameOnScreen(chart);
				chart.setVisible(true);
				
			}
		});
		p2.add(humidityText);
		p2.add(humidityBtn);

		allPanel.add(p2);

		p3 = new JPanel(new GridLayout(1, 2));
		indoorDustText = new JLabel();
		indoorDustText.setText("실내먼지");
		indoorDustBtn = new JButton("실외 먼지 변화");

		p3.add(indoorDustText);
		p3.add(indoorDustBtn);

		allPanel.add(p3);

		p4 = new JPanel(new GridLayout(1, 2));
		outdoorDustText = new JLabel();
		outdoorDustText.setText("실외먼지");
		outdoorDustBtn = new JButton("실외 먼지 변화");

		p4.add(outdoorDustText);
		p4.add(outdoorDustBtn);

		allPanel.add(p4);

		add(allPanel);
		setVisible(true);
	}
}
