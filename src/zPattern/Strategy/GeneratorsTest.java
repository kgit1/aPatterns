package zPattern.Strategy;

public class GeneratorsTest {

	public static int size = 10;

	public static void main(String[] args) {
		// give CountingGenerator class as argument to test method
		test(CountingGenerator.class);

	}

	// method get some class as argument
	// get classes inside by reflection
	// and invoke 10 times next() from instance of each class
	public static void test(Class<?> surroundingClass) {
		// getClasses() - Returns an array containing Class objects representing
		// all
		// the public classes and interfaces that are members of the class
		// represented by this Class object.
		for (Class<?> type : surroundingClass.getClasses()) {
			System.out.print(type.getSimpleName() + ": ");

			try {
				// create new instance of class
				Generator<?> g = (Generator<?>) type.newInstance();
				for (int i = 0; i < size; i++) {
					// invoke next()
					System.out.printf(g.next() + " ");
				}
				System.out.println();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
