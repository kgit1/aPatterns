package zPattern.Factory;

public class CurrencyFactoryClass {
	// factory client code
	public static void main(String[] args) {
		String country = "india";
		Currency rupee = CurrencyFactory.createCurrency(country);
		System.out.println(rupee.getSymbol());
		country = "singapore";
		Currency sgd = CurrencyFactory.createCurrency(country);
		System.out.println(sgd.getSymbol());
		country = "us";
		Currency us = CurrencyFactory.createCurrency(country);
		System.out.println(us.getSymbol());

	}
}

interface Currency {
	String getSymbol();
}

// concrete Rupee class code
class Rupee implements Currency {

	@Override
	public String getSymbol() {
		return "Rs";
	}
}

// concrete SGDDollar class code
class SGDDollar implements Currency {

	@Override
	public String getSymbol() {
		return "SGD";
	}
}

// concrete USDollar class code
class USDollar implements Currency {

	@Override
	public String getSymbol() {
		return "Us";
	}
}

// factory class code
class CurrencyFactory {
	public static Currency createCurrency(String country) {
		if (country.equalsIgnoreCase("India")) {
			return new Rupee();
		}
		if (country.equalsIgnoreCase("Singapore")) {
			return new SGDDollar();
		}
		if (country.equalsIgnoreCase("US")) {
			return new USDollar();
		}
		throw new IllegalArgumentException("No such currency");
	}
}
