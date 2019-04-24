import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	// Complete the caesarCipher function below.
	static String caesarCipher(String s, int k) {
		StringBuilder res = new StringBuilder();
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		// ASCII 97 - 122
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (isValidChar(c)) {
				char newChar = alphabet.charAt(
						(Character.toLowerCase(c) - 97 + k) % alphabet.length()
				);
				if (Character.isUpperCase(c)) {
					res.append(Character.toUpperCase(newChar));
				} else {
					res.append(newChar);
				}
			} else {
				res.append(c);
			}
		}
		return res.toString();
	}

	public static boolean isValidChar(char c) {
		return (97 <= Character.toLowerCase(c) && Character.toLowerCase(c) <= 122);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String s = scanner.nextLine();

		int k = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String result = caesarCipher(s, k);

		bufferedWriter.write(result);
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
