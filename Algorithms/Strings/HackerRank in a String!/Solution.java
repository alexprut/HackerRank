import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static String find(String s) {
		String match = "hackerrank";
		if (s.length() < match.length()) { return "NO"; }
		int i = 0; int j = 0;
		while (i < s.length()) {
			if (s.charAt(i) == match.charAt(j)) { j++; }
			i++;

			if (j == match.length()) { break; }
		}

		if (j < match.length()) { return "NO"; }

		return "YES";
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for(int a0 = 0; a0 < q; a0++){
			String s = in.next();
			System.out.println(Solution.find(s));
		}
	}
}
