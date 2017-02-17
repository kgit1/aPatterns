package l1.Duck.PatternsOfPattern;

//Pattern Adapter
public class GooseAdapter implements Quackable {

	Goose goose;

	public GooseAdapter(Goose goose) {
		this.goose = goose;
	}

	@Override
	public void quack() {
		goose.honk();
	}
}
