package I2.DinnerMenu.BuiltInIterator.IteratorPattern;

public class MenuTest {

	public static void main(String[] args) {
		PancakeMenu pancakeMenu = new PancakeMenu();
		DinerMenu dinerMenu = new DinerMenu();
		DinerMenuAlternate dinerMenuAlternate = new DinerMenuAlternate();
		CafeMenu cafeMenu = new CafeMenu();

		Waitress waitress = new Waitress(pancakeMenu, dinerMenu, dinerMenuAlternate, cafeMenu);

		waitress.printMenu();
	}
}
