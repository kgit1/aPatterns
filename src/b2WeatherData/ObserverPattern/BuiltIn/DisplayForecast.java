package b2WeatherData.ObserverPattern.BuiltIn;

import java.util.Observable;
import java.util.Observer;

public class DisplayForecast implements Observer, DisplayElement {

	private Observable observable;
	private float temperature;
	private float humidity;
	private float pressure;

	public DisplayForecast(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void display() {
		System.out.println("Forecast conditions: ");
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