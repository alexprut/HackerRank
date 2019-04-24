import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	// Complete the palindromeIndex function below.
	static int palindromeIndex(String s) {
		if (isPalindrom(s)) { return -1; }
		int i = 0;
		while (i < s.length() / 2 && s.charAt(i) == s.charAt(s.length() - 1 - i)) {
			i++;
		}
		String left = removeIndex(s, i);
		String right = removeIndex(s, s.length() - 1 - i);
		if (isPalindrom(left)) { return i; }
		if (isPalindrom(right)) { return s.length() - 1 - i; }
		return -1;
	}

	static String removeIndex(String s, int index) {
		String left = s.substring(0, index);
		String right = s.substring(index + 1, s.length());
		return left + right;
	}

	static boolean isPalindrom(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s = scanner.nextLine();

			int result = palindromeIndex(s);

			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
