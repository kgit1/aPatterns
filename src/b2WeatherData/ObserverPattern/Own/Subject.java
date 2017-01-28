package b2WeatherData.ObserverPattern.Own;

public interface Subject {
	void registerObserver(Observer o);

	void removeObserver(Observer o);

	void notifyObservers();
}
