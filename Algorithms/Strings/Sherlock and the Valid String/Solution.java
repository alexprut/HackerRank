import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.Map.Entry;
import java.util.regex.*;

public class Solution {

	// Complete the isValid function below.
	static String isValid(String s) {
		int[] cache = new int[26];
		for (int i = 0; i < s.length(); i++) {
			cache[((int) (s.charAt(i))) - 97]++;
		}

		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
		for (int i = 0; i < 26; i++) {
			if (cache[i] != 0) {
				if (h.containsKey(cache[i])) {
					h.put(cache[i], h.get(cache[i]) + 1);
				} else {
					h.put(cache[i], 1);
				}
			}
		}

		if (h.size() > 2) {
			return "NO";
		}
		if (h.size() <= 1) {
			return "YES";
		}

		// (equal chars occurrence, different chars)
		ArrayList<Entry<Integer, Integer>> list = new ArrayList<>(h.entrySet());
		if (list.get(0).getValue() == 1) {
			if ((list.get(0).getKey() - 1 == list.get(1).getKey()) || list.get(0).getKey() == 1) {
				return "YES";
			}
		} else if (list.get(1).getValue() == 1) {
			if ((list.get(1).getKey() - 1 == list.get(0).getKey()) || list.get(1).getKey() == 1) {
				return "YES";
			}
		}

		return "NO";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = scanner.nextLine();

		String result = isValid(s);

		bufferedWriter.write(result);
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
