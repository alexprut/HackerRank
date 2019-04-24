import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	// Complete the commonChild function below.
	static int commonChild(String s1, String s2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i <= s1.length(); i++) { dp[i][0] = 0; }
		for (int i = 0; i <= s2.length(); i++) { dp[0][i] = 0; }

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
				}
			}
		}

		return dp[s1.length()][s2.length()];
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s1 = scanner.nextLine();

		String s2 = scanner.nextLine();

		int result = commonChild(s1, s2);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
