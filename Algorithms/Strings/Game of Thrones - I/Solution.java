import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	// Complete the gameOfThrones function below.
	static String gameOfThrones(String s) {
		int[] cache = new int[26];
		for (int i = 0; i < s.length(); i++) {
			cache[((int) s.charAt(i)) - 97]++;
		}

		boolean isFirstOne = false;
		boolean canHaveOne = (s.length() % 2 == 0) ? false : true;
		for (int i = 0; i < 26; i++) {
			if (cache[i] % 2 != 0 && !canHaveOne) {
				return "NO";
			}

			if (cache[i] % 2 != 0 && isFirstOne) {
				return "NO";
			}

			if (cache[i] % 2 != 0 && canHaveOne) {
				isFirstOne = true;
			}
		}

		return "YES";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = scanner.nextLine();

		String result = gameOfThrones(s);

		bufferedWriter.write(result);
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
