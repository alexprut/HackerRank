import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
	static int validate(char c1, char c2, String s) {
		char next = '?';
		int counter = 0;
		for (int i = 0; i < s.length(); i++) {
			char current = s.charAt(i);
			if (next == '?') {
				if (current == c1) {
					counter++;
					next = c2;
				} else if (current == c2) {
					counter++;
					next = c1;
				}
			} else {
				if (current == c1 && current != next) { return 0; }
				if (current == c2 && current != next) { return 0; }
				if (current == c1 && current == next) { counter++; next = c2; }
				if (current == c2 && current == next) { counter++; next = c1; }
			}
		}

		return counter;
	}

	// Complete the alternate function below.
	static int alternate(String s) {
		if (s.length() < 2) {
			return 0;
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < 26; i++) {
			for (int j = i + 1; j < 26; j++) {
				max = Math.max(max, validate((char) (i + 97), (char)(j + 97), s));
			}
		}

		return max;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int l = Integer.parseInt(bufferedReader.readLine().trim());

		String s = bufferedReader.readLine();

		int result = alternate(s);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
