package xxx.temp;

public class NestedTest {

	public static void main(String[] args) {

		Nest nest = new Nest("Nest?");
		Nest.InnerClass in = nest.new InnerClass("we in?");
		Nest.NestedClass st = new Nest.NestedClass("static");

	}

}
