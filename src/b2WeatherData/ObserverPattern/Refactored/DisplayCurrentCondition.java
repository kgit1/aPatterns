package b2WeatherData.ObserverPattern.Refactored;

import java.util.Observable;
import java.util.Observer;

public class DisplayCurrentCondition implements Observer, DisplayElement {

	private Observable observable;
	private float temperature;
	private float humidity;
	private float pressure;

	public DisplayCurrentCondition(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void display() {
		System.out.println("Current conditions: " + temperature
				+ "C degrees and " + humidity + "% humidity and " + pressure
				+ " pressure");
	}

	@Override
	public void update(Observable observable, Object arg) {
		if (observable instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) observable;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			this.pressure = weatherData.getPressure();
		}
		display();
	}
}
