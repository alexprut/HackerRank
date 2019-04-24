
import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

	static boolean check(String s, BigInteger prev) {
		if (s.length() == 0) {
			return true;
		}

		if (s.charAt(0) == '0') {
			return false;
		}

		int i = 0;
		while (i < s.length()) {
			BigInteger current = new BigInteger(s.substring(0, i + 1));
			BigInteger diff = current.add(prev.negate());
			boolean result = diff.equals(BigInteger.ONE);
			if (result) {
				return check(s.substring(i + 1, s.length()), current);
			}
			i++;
		}

		return false;
	}

	// Complete the separateNumbers function below.
	static String separateNumbers(String s) {
		boolean[] res = new boolean[s.length()];
		for (int i = 0; i < s.length() - 1; i++) {
			res[i] = check(s.substring(i+1, s.length()), new BigInteger(s.substring(0, i+1)));
		}

		for (int i = 0; i < s.length(); i++) {
			if (res[i]) {
				return "YES " + s.substring(0, i + 1);
			}
		}

		return "NO";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s = scanner.nextLine();

			System.out.println(separateNumbers(s));
		}

		scanner.close();
	}
}
