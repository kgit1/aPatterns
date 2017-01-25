package code;

//Write a function that takes in a string of one or more words, and returns 
//the same string, but with all five or more letter words reversed 
//(Just like the name of this Kata). 
public class SpinWords {

	public static void main(String[] args) {
		System.out.println(spinWords("Hey fellow warriors"));
		System.out.println(spinWords("This is a test"));
		System.out.println(spinWords("This is another test"));
	}

	// mine
	public static String spinWords(String sentence) {
		String[] split = sentence.split(" ");
		for (int i = 0; i < split.length; i++) {
			if (split[i].length() >= 5) {
				char[] temp = split[i].toCharArray();
				split[i] = "";
				for (int j = temp.length - 1; j >= 0; j--) {
					split[i] += temp[j];
				}
			}
		}
		sentence = "";
		for (int i = 0; i < split.length; i++) {
			sentence += split[i] + " ";
		}
		return sentence.trim();
	}

	// better
	public String spinWords1(String sentence) {
		String[] words = sentence.split(" ");
		for (int i = 0; i < words.length; i++) {
			if (words[i].length() >= 5) {
				words[i] = new StringBuilder(words[i]).reverse().toString();
			}
		}
		return String.join(" ", words);
	}

	// different
	public String spinWords2(String sentence) {
		StringBuilder sb = new StringBuilder();
		String[] words = sentence.split(" ");
		for (String word : words) {
			if (word.length() >= 5) {
				char[] charArr = word.toCharArray();
				for (int i = charArr.length - 1; i >= 0; i--) {
					sb.append(charArr[i]);
				}
			} else {
				sb.append(word);
			}
			sb.append(' ');
		}
		return sb.toString().trim();
	}

}
