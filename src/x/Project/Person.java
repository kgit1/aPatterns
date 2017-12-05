package x.Project;

import java.time.LocalDateTime;

public class Person {

	private String userName;
	private String password;
	private LocalDateTime created;
	private LocalDateTime modified;

	public Person(String userName, String password) {
		this.userName = userName;
		this.password = password;
		this.created = LocalDateTime.now();
		this.modified = LocalDateTime.now();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		modified = LocalDateTime.now();
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getCreated() {
		modified = LocalDateTime.now();
		return created;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	@Override
	public String toString() {
		return "Person [userName=" + userName + ", password=" + password + ", created=" + created + ", modified="
				+ modified + "]";
	}

}
