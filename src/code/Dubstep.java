package code;

import java.util.Arrays;

public class Dubstep {

	public static void main(String[] args) {
		String string = "WUBWUBIWUBWUBWUBWUBAMWUBWUBX";
		String[] s = string.split("WUB");
		String s2 = string.replace("WUB", " ").replaceAll("\\s+", " ").trim();
		System.out.println(s2);
		String s3 = string.replaceAll("(WUB)+", " ").trim();
		System.out.println(s3);
		String s1 = s.toString();
		System.out.println(Arrays.toString(s));
		System.out.println(s1.toString());
	}

}
