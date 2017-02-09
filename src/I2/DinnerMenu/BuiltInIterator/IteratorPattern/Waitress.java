package I2.DinnerMenu.BuiltInIterator.IteratorPattern;

import java.util.Iterator;

public class Waitress {

	Menu pancakeMenu;
	Menu dinerMenu;
	Menu dinerMenuAlternate;
	Menu cafeMenu;

	public Waitress(Menu pancakeMenu, Menu dinerMenu, Menu cafeMenu, Menu dinerMenuAlternate) {
		this.pancakeMenu = pancakeMenu;
		this.dinerMenu = dinerMenu;
		this.dinerMenuAlternate = dinerMenuAlternate;
		this.cafeMenu = cafeMenu;
	}

	public void printMenu() {
		Iterator pancakeIterator = pancakeMenu.createIterator();
		Iterator dinerIterator = dinerMenu.createIterator();
		Iterator dinerAlternateIterator = dinerMenuAlternate.createIterator();
		Iterator cafeIterator = cafeMenu.createIterator();

		System.out.println("MENU\n----\nBREAKFAST");
		printMenu(pancakeIterator);
		System.out.println("\nLUNCH");
		printMenu(dinerIterator);
		System.out.println("\nLUNCH");
		printMenu(dinerAlternateIterator);
		System.out.println("\nCafe");
		printMenu(cafeIterator);
	}

	private void printMenu(Iterator iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = (MenuItem) iterator.next();
			System.out.println(menuItem.getName() + ", ");
			System.out.println(menuItem.getPrice() + ", ");
			System.out.println(menuItem.getDescription());
		}
	}

	private void printBreakfastMenu() {
	}

	private void printLunchMenu() {
	}

	private void printVegetarianMenu() {
	}

	private void isVegetarian(String name) {
	}
}
