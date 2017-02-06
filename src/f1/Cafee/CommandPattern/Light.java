package f1.Cafee.CommandPattern;

//some device
public class Light {

	String location = "";

	public Light(String location) {
		this.location = location;
	}

	// available commands for device
	public void on() {
		System.out.println(location + " : light is On");
	}

	public void off() {
		System.out.println(location + " : light is Off");
	}
}
