package x.Project;

import java.util.ArrayList;

public interface Journal {

	Person getPersonData();

	int getNumberOfRecors();

	ArrayList<Record> getRecords();

	void addRecord(Record record);

}
