package h2.HomeTheater.FacadePattern;

public class Amplifier {

	public void on() {
		System.out.println("Amplifier On");
	}

	public void setDvd(DvdPlayer dvd) {
		System.out.println("Amplifier :set Dvd");
	}

	public void setSurround() {
		System.out.println("Amplifier : set Surround");
	}

	public void setVolume(int i) {
		System.out.println("Amplifier : set Volume");
	}

	public void off() {
		System.out.println("Amplifier Off");
	}
}
