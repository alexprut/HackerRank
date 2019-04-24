import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	// Complete the stringConstruction function below.
	static int stringConstruction(String s) {
		int[] cache = new int[26];
		for (int i = 0; i < s.length(); i++) {
			cache[((int) s.charAt(i)) - 97]++;
		}

		int counter = 0;
		for (int i = 0; i < 26; i++) {
			if (cache[i] != 0) {
				counter++;
			}
		}

		return counter;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s = scanner.nextLine();

			int result = stringConstruction(s);

			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
