package I1.DinnerMenu.IteratorPattern;

import java.util.ArrayList;

public class PancakeMenuIterator implements Iterator {
	ArrayList<MenuItem> items;
	int position;

	public PancakeMenuIterator(ArrayList items) {
		this.items = items;
	}

	@Override
	public boolean hasNext() {
		if (position >= items.size() || items.get(position) == null) {
			return false;
		}
		return true;
	}

	@Override
	public Object next() {
		MenuItem menuItem = items.get(position);
		position += 1;
		return menuItem;
	}
}
