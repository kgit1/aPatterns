package b2WeatherData.ObserverPattern;

public class DisplayCurrentCondition implements Observer, DisplayElement {

	private float temperature;
	private float humidity;
	private float pressure;

	@Override
	public void display() {
		System.out.println("Current conditions: " + temperature
				+ " C degrees and " + humidity + "% humidity and " + pressure
				+ " pressure");
	}

	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
	}
}
