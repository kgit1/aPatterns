package I1.DinnerMenu.IteratorPattern;

public class DinnerMenuIterator implements Iterator {
	MenuItems[] items;
	int position;

	public DinnerMenuIterator(MenuItems[] items) {
		this.items = items;
	}

	@Override
	public boolean hasNext() {
		if (position >= items.length || items[position] == null) {
			return false;
		}
		return true;
	}

	@Override
	public Object next() {
		MenuItems menuItem = items[position];
		position += 1;
		return menuItem;
	}
}
