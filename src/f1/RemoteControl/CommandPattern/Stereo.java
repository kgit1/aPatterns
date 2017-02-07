package f1.RemoteControl.CommandPattern;

public class Stereo {

	String location;

	public Stereo(String location) {
		this.location = location;
	}

	public void on() {
		System.out.println(location + " : stereo On");
	}

	public void off() {
		System.out.println(location + " : stereo Off");
	}

	public void setCd() {
		System.out.println(location + " : set Cd");
	}

	public void SetDvd() {
		System.out.println(location + " : set DVD");
	}

	public void setRadio() {
		System.out.println(location + " : set Radio");
	}

	public void setVolume() {
		System.out.println(location + " : set Volume");
	}
}
