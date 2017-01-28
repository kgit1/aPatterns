package b2WeatherData.ObserverPattern.Own;

public class WeatherStation {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();

		DisplayCurrentCondition displayCurrentCondition = new DisplayCurrentCondition(
				weatherData);
		DisplayStatistics displayStatistics = new DisplayStatistics(
				weatherData);
		DisplayForecast displayForecast = new DisplayForecast(weatherData);
		DisplayHeatIndex displayHeatIndex=new DisplayHeatIndex(weatherData);
		
		weatherData.setMeasurements(25, 88, 1025);
		System.out.println();
		weatherData.setMeasurements(23, 75, 1018);
		System.out.println();
		weatherData.setMeasurements(18, 73, 1022);
		System.out.println();
		weatherData.setMeasurements(15, 68, 1012);
		
	}
}
