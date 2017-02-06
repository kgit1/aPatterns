package f1.Cafee.CommandPattern;

public class NoCommand implements Command {

	@Override
	public void execute() {
		System.out.println("NOCommand");
	}
}
