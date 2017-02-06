package f1.Cafee.CommandPattern;

//concrete command object
public class LivingRoomLightOnCommand implements Command {
	
	//device
	Light light;

	public LivingRoomLightOnCommand(Light light) {
		this.light = light;
	}

	//invoke method from given device
	@Override
	public void execute() {
		light.on();
	}

}
