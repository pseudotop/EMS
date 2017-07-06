package app;

import thread.ThreadTask;

public class ClassEco {
	public static void main(String[] args) {
		new MyFrame();
		Thread thread1 = new Thread(new ThreadTask());
		thread1.start();
		
		try {
			thread1.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		ThreadTask tt = new ThreadTask();
		tt.dataControl();
	}
}
