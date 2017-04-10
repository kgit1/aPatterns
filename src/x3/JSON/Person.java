package x3.JSON;

import java.util.ArrayList;

public class Person {
	String city;
	String name;
	String mobile;
	ArrayList<String> friends;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public ArrayList<String> getFriends() {
		return friends;
	}

	public void setFriends(ArrayList<String> friends) {
		this.friends = friends;
	}

	@Override
	public String toString() {
		return "\t{\n\tcity: " + city + ",\n\tname: " + name + ",\n\tmobile: " + mobile + ",\n\tfriends: " + friends
				+ "\n\t}";
	}
}
