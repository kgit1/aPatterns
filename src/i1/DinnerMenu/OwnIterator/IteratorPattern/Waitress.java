package i1.DinnerMenu.OwnIterator.IteratorPattern;

public class Waitress {

	PancakeMenu pancakeMenu;
	DinerMenu dinerMenu;

	public Waitress(PancakeMenu pancakeMenu, DinerMenu dinerMenu) {
		super();
		this.pancakeMenu = pancakeMenu;
		this.dinerMenu = dinerMenu;
	}

	public void printMenu() {
		Iterator pancakeIterator = pancakeMenu.createIterator();
		Iterator dinerIterator = dinerMenu.createIterator();

		System.out.println("MENU\n----\nBREAKFAST");
		printMenu(pancakeIterator);
		System.out.println("\nLUNCH");
		printMenu(dinerIterator);
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
