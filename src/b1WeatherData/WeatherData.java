package b1WeatherData;

public class WeatherData {

	CurrentDisplay currentConditionDisplay = new CurrentDisplay();
	StaticsDisplay staticsDisplay = new StaticsDisplay();
	ForecastDisplay forecastDisplay = new ForecastDisplay();

	public float getTemperature() {
		return 0.1f;
	}

	public float getHumidity() {
		return 0.1f;
	}

	public float getPressure() {
		return 0.1f;
	}

	public void measurementChanged() {
		float temp = getTemperature();
		float humidity = getHumidity();
		float pressure = getPressure();

		currentConditionDisplay.update(temp, humidity, pressure);
		staticsDisplay.update(temp, humidity, pressure);
		forecastDisplay.update(temp, humidity, pressure);
	}

	interface Display {
		void update(float temp, float humidity, float pressure);
	}

	class CurrentDisplay implements Display {

		@Override
		public void update(float temp, float humidity, float pressure) {
			// TODO Auto-generated method stub

		}
	}

	class StaticsDisplay implements Display {

		@Override
		public void update(float temp, float humidity, float pressure) {
			// TODO Auto-generated method stub

		}
	}

	class ForecastDisplay implements Display {

		@Override
		public void update(float temp, float humidity, float pressure) {
			// TODO Auto-generated method stub

		}
	}
}
