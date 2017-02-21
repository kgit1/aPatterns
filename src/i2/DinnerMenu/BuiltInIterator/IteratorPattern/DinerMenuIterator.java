package i2.DinnerMenu.BuiltInIterator.IteratorPattern;

import java.util.Iterator;

public class DinerMenuIterator implements Iterator<MenuItem> {
	MenuItem[] menuItems;
	int position;

	public DinerMenuIterator(MenuItem[] items) {
		this.menuItems = items;
	}

	@Override
	public boolean hasNext() {
		if (position >= menuItems.length || menuItems[position] == null) {
			return false;
		}
		return true;
	}

	@Override
	public MenuItem next() {
		MenuItem menuItem = menuItems[position];
		position += 1;
		return menuItem;
	}

	@Override
	public void remove() {
		if (position <= 0) {
			throw new IllegalStateException("You can't remove an item until you've done at least one next()");
		}
		if (menuItems[position - 1] != null) {
			for (int i = position; i < (menuItems.length - 1); i++) {
				menuItems[i] = menuItems[i + 1];
			}
			menuItems[menuItems.length - 1] = null;
		}
	}
}
