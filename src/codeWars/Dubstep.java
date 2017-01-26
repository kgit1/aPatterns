package codeWars;

public class Dubstep {

	public static void main(String[] args) {
		String string = "WUBWUBIWUBWUBWUBWUBAMWUBWUBX";

		String s2 = string.replace("WUB", " ").replaceAll("\\s+", " ").trim();
		System.out.println(s2);
		String s3 = string.replaceAll("(WUB)+", " ").trim();
		System.out.println(s3);
	}

}
