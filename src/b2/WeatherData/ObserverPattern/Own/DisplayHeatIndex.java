package b2.WeatherData.ObserverPattern.Own;

public class DisplayHeatIndex implements Observer, DisplayElement {

	private float heatIndex = 0.0f;
	private Subject weatherData;

	public DisplayHeatIndex(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	@Override
	public void display() {
		System.out.println("HeatIndex is: "+heatIndex);
	}

	@Override
	public void update(float temperature, float humidity, float pressure) {
		float t = temperature;
		float h = humidity;
		heatIndex = (float) ((16.923 + (0.185212 * t)) + (5.37941 * h)
				- (0.100254 * t * h) + (0.00941695 * (t * t))
				+ (0.00728898 * (h * h)) + (0.000345372 * (t * t * h))
				- (0.000814971 * (t * h * h))
				+ (0.0000102102 * (t * t * h * h))
				- (0.000038646 * (t * t * t)) + (0.0000291583 * (h * h * h))
				+ (0.00000142721 * (t * t * t * h))
				+ (0.000000197483 * (t * h * h * h))
				- (0.0000000218429 * (t * t * t * h * h))
				+ (0.000000000843296 * (t * t * h * h * h))
				- (0.0000000000481975 * (t * t * t * h * h * h)));
		display();
	}
}
