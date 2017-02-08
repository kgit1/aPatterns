package g1.Starbuzz.TemplateMethodPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoffeeWithHook extends CaffeineBeverageWithHook {

	@Override
	void brew() {
		System.out.println("Dripping Coffee through filter");
	}

	@Override
	void addCondiments() {
		System.out.println("Adding sugar and milk");
	}

	// here we use hook and give him needed functionality
	public boolean customerWantsCondiments() {
		String answer = userInput();
		if (answer.toLowerCase().startsWith("y")) {
			return true;
		} else {
			return false;
		}
	}

	private String userInput() {
		String answer = null;
		System.out.println("Would you like milk and sugar with your coffee (y/n)?");

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		try {
			answer = input.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (answer == null) {
			return "no";
		}
		return answer;
	}
}
