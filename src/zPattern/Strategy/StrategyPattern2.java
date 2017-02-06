package zPattern.Strategy;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Java program to implement Strategy design pattern and Open Closed design
 * principle. filter() method uses Strategy pattern to filter messages.
 *
 * @author Javin Paul
 */
public class StrategyPattern2 {

	public static void main(String args[]) {
		List<Message> messages = new ArrayList<>();
		messages.add(
				new Message(MessageType.TEXT, 100, "This is test message"));
		messages.add(new Message(MessageType.XML, 200, "How are you "));
		messages.add(new Message(MessageType.TEXT, 300,
				"Does Strategy pattern follows OCP design principle?"));
		messages.add(new Message(MessageType.TEXT, 400,
				"Wrong Message, should be filtered"));

		messages = filter(messages, new FilterByType(MessageType.XML));
		messages = filter(messages, new FilterByKeyword("Wrong"));
		messages = filter(messages, new FilterBySize(200));
	}

	// This method confirms Open Closed design principle, It's open for
	// modification, because you can provide any filtering criterion by
	// providing implementation of FilteringStrategy, but no need to change any
	// code here. New functionality will be provided by new code.
	public static final List<Message> filter(List<Message> messageList,
			FilteringStrategy strategy) {

		Iterator<Message> itr = messageList.iterator();

		while (itr.hasNext()) {
			Message msg = itr.next();
			if (strategy.isFilterable(msg)) {
				System.out.println(strategy.toString() + msg);
				itr.remove();
			}
		}
		return messageList;
	}
}

// A class to represent a Message with type, size and content
class Message {
	private MessageType type;
	private int size;
	private String content;

	public Message(MessageType type, int size, String content) {
		this.type = type;
		this.size = size;
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public int getSize() {
		return size;
	}

	public MessageType getType() {
		return type;
	}

	@Override
	public String toString() {
		return " Message{" + "type=" + type + ", size=" + size + ", content="
				+ content + '}';
	}
}

// Enum to denote different Message type
enum MessageType {
	TEXT, BYTE, XML;
}

// This is the core interface to define Strategy
// interface which defines Strategy for this pattern.
interface FilteringStrategy {
	public boolean isFilterable(Message msg);
}

// This is one implementation of Strategy interface, which filters messages
// by their type.
// An implementation of Strategy interface, which decides to filter message by
// type.
class FilterByType implements FilteringStrategy {
	private MessageType type;

	public FilterByType(MessageType type) {
		this.type = type;
	}

	@Override
	public boolean isFilterable(Message msg) {
		return type == msg.getType();
	}

	@Override
	public String toString() {
		return "Filtering By type: " + type;
	}

}

// Another Strategy implementation for filtering message by size
class FilterBySize implements FilteringStrategy {
	private int maxSize;

	public FilterBySize(int maxSize) {
		this.maxSize = maxSize;
	}

	@Override
	public boolean isFilterable(Message msg) {
		return msg.getSize() > maxSize;
	}

	@Override
	public String toString() {
		return "Filtering By maxSize: " + maxSize;
	}
}

// Here is one more implementation of Strategy
// interface which will filter messages by keywords
// Another Strategy implementation for filtering message by keyword in
// content.

class FilterByKeyword implements FilteringStrategy {
	private String keyword;

	public FilterByKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public boolean isFilterable(Message msg) {
		return msg.getContent() == null || msg.getContent().contains(keyword);
	}

	@Override
	public String toString() {
		return "Filtering By keyword: " + keyword;
	}

}
// Output:
// - Filtering By type: XML Message{type=XML, size=200, content=<data>How are
// you </data>}
// - Filtering By keyword: Wrong Message{type=TEXT, size=400, content=Wrong
// Message, should be filtered}
// - Filtering By maxSize: 200 Message{type=TEXT, size=300, content=Does
// Strategy pattern follows OCP design principle?}
//
// You can see that our List contains four messages one of type XML and three of
// type TEXT. So when we first filter messages by type XML, you can see that
// only the message with XML type is filtered. Next, when we filter messages
// based upon keyword "Wrong", only the message which contains this keyword are
// filtered.
//
// Lastly, when I filtered messages on the size of 200, only the message whose
// size is greater than 200 are filtered. So we can do different things from
// same code by just providing a new implementation of Strategy interface, this
// is the power of Strategy design pattern.