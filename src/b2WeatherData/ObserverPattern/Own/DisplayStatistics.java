package b2WeatherData.ObserverPattern.Own;

public class DisplayStatistics implements Observer, DisplayElement {

	private float temperature;
	private float humidity;
	private float pressure;
	private Subject weatherData;

	public DisplayStatistics(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	
	@Override
	public void display() {
		System.out.println("Static conditions there");
	}

	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		display();
	}
}
