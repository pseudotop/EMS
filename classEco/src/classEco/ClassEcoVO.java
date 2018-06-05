package classEco;

import java.io.Serializable;

public class ClassEcoVO implements Serializable{
	private double temperature;			//온도
	private double humidity;			//습도
	private double innerDust;			//내부먼지
	private double outerDust;			//외부먼지
	private String reg_time;			//데이터 등록 시간

	public ClassEcoVO() {
		super();
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public double getHumidity() {
		return humidity;
	}
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}
	public double getInnerDust() {
		return innerDust;
	}
	public void setInnerDust(double innerDust) {
		this.innerDust = innerDust;
	}
	public double getOuterDust() {
		return outerDust;
	}
	public void setOuterDust(double outerDust) {
		this.outerDust = outerDust;
	}
	public String getRegtime() {
		return reg_time;
	}
	public String setRegTime(String reg_time) {
		return this.reg_time = reg_time;
	}
	
	@Override
	public String toString() {
		return "ClassEcoVO [temperature=" + temperature + ", humidity=" + humidity + ", innerDust=" + innerDust
				+ ", outerDust=" + outerDust + "]";
	}
	
	
}
