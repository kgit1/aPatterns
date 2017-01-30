package c1.Sratbuzz.DecoratorPattern;

import java.awt.Color;

public abstract class Beverage {
	String description = "Unknown Beverage";
	
	Color color = new Color(123);

	public String getDescription() {
		return description;
	}

	public abstract double cost();

	// to do
//	public void getSize() {
//	};
//
//	public void setSize() {
//	};
}
