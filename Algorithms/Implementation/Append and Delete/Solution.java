import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	// Complete the appendAndDelete function below.
	static String appendAndDelete(String s, String t, int k) {
		int i = 0;
		while (i < s.length() && i < t.length() && s.charAt(i) == t.charAt(i)) { i++; }
		int toChange = (s.length() - i) + (t.length() - i);
		if (toChange % 2 == 1 && k % 2 == 0) {
			return "No";
		}

		if (toChange > k) {
			return "No";
		}

		return "Yes";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = scanner.nextLine();

		String t = scanner.nextLine();

		int k = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String result = appendAndDelete(s, t, k);

		bufferedWriter.write(result);
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
