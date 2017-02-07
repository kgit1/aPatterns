package f1.RemoteControl.CommandPattern;

public class NoCommand implements Command {

	@Override
	public void execute() {
		System.out.println("NOCommand");
	}

	@Override
	public void undo() {
		System.out.println("NOCommand");
	}
}
