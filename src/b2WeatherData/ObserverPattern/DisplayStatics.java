package b2WeatherData.ObserverPattern;

public class DisplayStatics implements Observer, DisplayElement {

	private float temperature;
	private float humidity;
	private float pressure;

	@Override
	public void display() {
		System.out.println("Static conditions there");
	}

	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
	}
}
