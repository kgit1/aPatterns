package f1.Cafee.CommandPattern;

public class LightOnCommant implements Command {
	Light light;

	public LightOnCommant(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.on();
	}

}
