package x.Project;

import java.util.ArrayList;
import java.util.List;

public class User implements Journal {

	private Person person;
	private int numberOfRecords;
	private List<Record> records;

	public User(Person person) {
		this.person = person;
		numberOfRecords = 0;
		records = new ArrayList<>();
	}

	@Override
	public Person getPersonData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumberOfRecors() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Record> getRecords() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addRecord(Record record) {
		// TODO Auto-generated method stub
		
	}

}
