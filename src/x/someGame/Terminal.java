package x.someGame;

//Второй класс, который отвечает за терминал

import java.util.Scanner;

public class Terminal implements Runnable {

	private SomeonesGame gameLogic;
	private Scanner scanner;

	Terminal() {
		new Thread(this).start();
	}

	public void run() {

		scanner = new Scanner(System.in);
		System.out.println("=========> Bulls and Cows");
		System.out.println("======> Welcome to the game");
		System.out.println("Enter limit digit and limit moves");
		while (true) {
			try {
				System.out.println("Limit digit = ");
				int limit = Integer.parseInt(scanner.nextLine());
				System.out.println("Limit moves = ");
				int limitMoves = Integer.parseInt(scanner.nextLine());
				gameLogic = new SomeonesGame(limit, limitMoves);
				break;
			} catch (Throwable e) {
				System.out.println(e.getMessage());
			}
		}

		do {
			System.out.println("You must to select play mode:  ");
			System.out.println(
					"Type: \"two players\" for PvP, type something other for Artificial Intelligence (without \"\")");

			gameLogic.modePvP = (scanner.nextLine().equalsIgnoreCase("two players"));

			for (int move = 0; move < gameLogic.getLimitMoves(); move++) {
				int result = 0;
				System.out.println("Left moves: " + (gameLogic.getLimitMoves() - move));
				try {
					result = update();
				} catch (SomeonesGame.IncorrectValueException | NumberFormatException e) {
					System.out.println(e.getMessage());
					move--;

					continue;
				}
				if (result == gameLogic.getLimitDigit()) {
					System.out.println("You won!!!");
					break;
				}
				if (move + 1 == gameLogic.getLimitMoves()) {
					System.out.println("Moves are not enough");
					break;
				}
			}
			System.out.println("Game over");
			System.out.println("Type \"exit\" for exit from game, something other for play again(without \"\")");

		} while (!scanner.nextLine().equalsIgnoreCase("exit"));
	}

	private int update() throws SomeonesGame.IncorrectValueException {
		if (gameLogic.modePvP) {
			System.out.println("Enter the value for PvP");
			gameLogic.setValueGame(Integer.parseInt(scanner.nextLine()));
			gameLogic.modePvP = false;
		}
		System.out.println("Enter the value");
		gameLogic.setValuePlayer(Integer.parseInt(scanner.nextLine()));
		int[] result = gameLogic.countBullsAndCows();
		System.out.println("Bulls: " + result[0] + " <-> Cows: " + result[1]);

		return result[0];
	}

	public static void main(String[] args) {
		new Terminal();
	}
}