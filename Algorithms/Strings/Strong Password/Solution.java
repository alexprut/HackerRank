import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	// Complete the minimumNumber function below.
	static int minimumNumber(int n, String password) {
		int digit = 0;
		int lowerCase = 0;
		int upperCase = 0;
		int special = 0;
		for (int i = 0; i < password.length(); i++) {
			char c = password.charAt(i);
			if (isDigit(c)) { digit++; }
			if (isLowerCase(c)) { lowerCase++; }
			if (isUpperCase(c)) { upperCase++; }
			if (isSpecial(c)) { special++; }
		}
		int miss = 0;
		if (digit == 0) { miss++; }
		if (lowerCase == 0) { miss++; }
		if (upperCase == 0) { miss++; }
		if (special == 0) { miss++; }
		int missingLength = (password.length() - 6 < 0) ? 6 - password.length(): 0;
		if (miss < missingLength) {
			return missingLength;
		}
		return miss;
	}

	static boolean isDigit(char c) { return 48 <= c && c <= 57; }
	static boolean isLowerCase(char c) { return 97 <= c && c <= 122; }
	static boolean isUpperCase(char c) { return 65 <= c && c <= 90; }
	static boolean isSpecial(char c) {
		return (
				c == '!' || c == '@' || c == '#' || c == '$' || c == '%' || c == '^' ||
						c == '&' || c == '*' || c == '(' || c == ')' || c == '-' || c == '+'
		);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String password = scanner.nextLine();

		int answer = minimumNumber(n, password);

		bufferedWriter.write(String.valueOf(answer));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
