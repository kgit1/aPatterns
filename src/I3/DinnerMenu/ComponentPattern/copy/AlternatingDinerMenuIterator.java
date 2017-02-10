package I3.DinnerMenu.ComponentPattern.copy;

import java.util.Calendar;
import java.util.Iterator;

public class AlternatingDinerMenuIterator implements Iterator<MenuItem> {

	MenuItem[] items;
	int position;

	public AlternatingDinerMenuIterator(MenuItem[] items) {
		this.items = items;
		Calendar rightNow = Calendar.getInstance();
		position = rightNow.get(Calendar.DAY_OF_WEEK) % 2;
	}

	@Override
	public boolean hasNext() {
		if (position >= items.length || items[position] == null) {
			return false;
		}
		return true;
	}

	@Override
	public MenuItem next() {
		MenuItem menuItem = items[position];
		position += 2;
		return menuItem;
	}

	public void remove() {
		throw new UnsupportedOperationException("Does not support remove()");
	}
}
