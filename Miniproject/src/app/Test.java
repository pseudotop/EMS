package app;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.ui.RefineryUtilities;

public class Test extends JFrame {

	JPanel allPanel, p1, p2, p3, p4;
	JButton tempBtn, humidityBtn, indoorDustBtn, outdoorDustBtn;
	JLabel tempText, humidityText, indoorDustText, outdoorDustText;

	public Test() {
		setBackground(Color.GREEN);
		setSize(300, 200);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("���ǽ� ȯ�� ���� �ý���");

		allPanel = new JPanel(new FlowLayout());

		p1 = new JPanel(new GridLayout(1, 2));
		tempText = new JLabel();
		tempText.setText("�µ�");

		tempBtn = new JButton("�µ� ��ȭ");
		tempBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				TempLineChart chart = new TempLineChart("�µ� ��ȭ", "Temperature");

				chart.pack();
				RefineryUtilities.centerFrameOnScreen(chart);
				chart.setVisible(true);

			}
		});
		p1.add(tempText);
		p1.add(tempBtn);

		allPanel.add(p1);

		p2 = new JPanel(new GridLayout(1, 2));
		humidityText = new JLabel();
		humidityText.setText("����");
		humidityBtn = new JButton("���� ��ȭ");
		p2.add(humidityText);
		p2.add(humidityBtn);

		allPanel.add(p2);

		p3 = new JPanel(new GridLayout(1, 2));
		indoorDustText = new JLabel();
		indoorDustText.setText("�ǳ�����");
		indoorDustBtn = new JButton("�ǿ� ���� ��ȭ");

		p3.add(indoorDustText);
		p3.add(indoorDustBtn);

		allPanel.add(p3);

		p4 = new JPanel(new GridLayout(1, 2));
		outdoorDustText = new JLabel();
		outdoorDustText.setText("�ǿܸ���");
		outdoorDustBtn = new JButton("�ǿ� ���� ��ȭ");

		p4.add(outdoorDustText);
		p4.add(outdoorDustBtn);

		allPanel.add(p4);

		add(allPanel);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Test();
	}
}
