package vo;

import java.util.Date;

public class EnvironmentVO {
	private Date environmentDate;
	private int temperature;
	private int humidity;
	private int indoorDust;
	private int outdoorDust;
	
	public EnvironmentVO() {
		super();
	}

	public EnvironmentVO(Date environmentDate, int temperature, int humidity, int indoorDust, int outdoorDust) {
		super();
		this.environmentDate = environmentDate;
		this.temperature = temperature;
		this.humidity = humidity;
		this.indoorDust = indoorDust;
		this.outdoorDust = outdoorDust;
	}

	public Date getEnvironmentDate() {
		return environmentDate;
	}

	public void setEnvironmentDate(Date environmentDate) {
		this.environmentDate = environmentDate;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public int getIndoorDust() {
		return indoorDust;
	}

	public void setIndoorDust(int indoorDust) {
		this.indoorDust = indoorDust;
	}

	public int getOutdoorDust() {
		return outdoorDust;
	}

	public void setOutdoorDust(int outdoorDust) {
		this.outdoorDust = outdoorDust;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((environmentDate == null) ? 0 : environmentDate.hashCode());
		result = prime * result + humidity;
		result = prime * result + indoorDust;
		result = prime * result + outdoorDust;
		result = prime * result + temperature;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnvironmentVO other = (EnvironmentVO) obj;
		if (environmentDate == null) {
			if (other.environmentDate != null)
				return false;
		} else if (!environmentDate.equals(other.environmentDate))
			return false;
		if (humidity != other.humidity)
			return false;
		if (indoorDust != other.indoorDust)
			return false;
		if (outdoorDust != other.outdoorDust)
			return false;
		if (temperature != other.temperature)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EnvironmentVO [environmentDate=" + environmentDate + ", temperature=" + temperature + ", humidity="
				+ humidity + ", indoorDust=" + indoorDust + ", outdoorDust=" + outdoorDust + "]";
	}
	
}
