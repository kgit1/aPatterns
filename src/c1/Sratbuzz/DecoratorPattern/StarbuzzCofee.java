package c1.Sratbuzz.DecoratorPattern;

//decorator pattern (also known as Wrapper, an alternative naming shared 
//with the Adapter pattern) is a design pattern that allows behavior to be 
//added to an individual object, either statically or dynamically, without 
//affecting the behavior of other objects from the same class
public class StarbuzzCofee {

	public static void main(String[] args) {
		Beverage beverage = new Espresso();
		printCheck(beverage);

		Beverage beverage2 = new DarkRoast();
		beverage2 = new Mocha(beverage2);
		beverage2 = new Mocha(beverage2);
		beverage2 = new Whip(beverage2);
		printCheck(beverage2);

		Beverage beverage3 = new HouseBlend();
		beverage3 = new Soy(beverage3);
		beverage3 = new Mocha(beverage3);
		beverage3 = new Whip(beverage3);
		printCheck(beverage3);
	}

	public static void printCheck(Beverage beverage) {
		System.out.println("*******************\n" + beverage.getDescription()
				+ "\n-------------------\n \t     $" + beverage.cost()
				+ "\n===================");
	}
}
