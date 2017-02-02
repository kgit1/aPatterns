package d1.Pizza.FactoryPattern;

public class one {
	
	Pizza orderPizza(String type){
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}

}
