package classEco;

/*
 * 강의실 환경체크 서비스
 *  - 체크대상 : 내부온도, 내부습도, 내부먼지, 외부먼지
 *  - 멀티쓰레드 구현하여 실시간(1분텀) 데이터 반영
 */
public class ClassEco {

	public static void main(String[] args) {
		
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
