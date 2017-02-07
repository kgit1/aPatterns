package f1.RemoteControl.CommandPattern;

public class HottubOffCommand implements Command {

	Hottub hottub;

	public HottubOffCommand(Hottub hottub) {
		this.hottub = hottub;
	}

	public void execute() {
		hottub.cool();
		hottub.off();
	}

	@Override
	public void undo() {
		hottub.on();
		hottub.heat();
		hottub.bubblesOn();
	}
}