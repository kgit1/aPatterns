package zPattern.Factory;

//pattern Factory - creational pattern that uses factory methods to deal
//with problem of creating objects without having to specify exact class
//of the object that will be created
//we give some object as argument and method knows on his own what to 
//do when get object of that class

//When to use Factory design pattern in Java
//Static Factory methods are common in frameworks where library code needs 
//to create objects of types which may be sub classed by applications using 
//the framework.Some or all concrete products can be created in multiple ways,
//or we want to leave open the option that in the future there may be new ways 
//to create the concrete product.Factory method is used when Products don't need 
//to know how they are created.We can use factory pattern where we have to 
//create an object of any one of sub-classes depending on the data provided

public class Games {

	public static void main(String[] args) {
		playGame(new CheckersFactory());
		System.out.println("=============");
		playGame(new ChessFactory());
	}

	public static void playGame(GameFactory factory) {
		Game game = factory.getGame();
		while (game.move()) {
		}
	}
}

interface Game {
	boolean move();
}

interface GameFactory {
	Game getGame();
}

class Chess implements Game {

	private int moves = 0;
	private static final int MOVES = 3;

	@Override
	public boolean move() {
		System.out.println("Chess move " + moves);
		return ++moves != MOVES;
	}
}

class Checkers implements Game {

	private int moves = 0;
	private static final int MOVES = 3;

	@Override
	public boolean move() {
		System.out.println("Checkers move " + moves);
		return ++moves != MOVES;
	}
}

class ChessFactory implements GameFactory {

	@Override
	public Game getGame() {
		return new Chess();
	}
}

class CheckersFactory implements GameFactory {

	@Override
	public Game getGame() {
		return new Checkers();
	}
}