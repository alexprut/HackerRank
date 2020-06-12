import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	static long flippingBits(long n) {
		String tmp = Long.toBinaryString(n);
		String res = "";
		int l = tmp.length();
		for (int i = 0; i < 32 - l; i++) {
			tmp = "0" + tmp;
		}
		for (int i = 0; i < tmp.length(); i++) {
			if (tmp.charAt(i) == '0') {
				res += "1";
			} else {
				res += "0";
			}
		}
		return Long.parseLong(res, 2);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			long n = scanner.nextLong();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			long result = flippingBits(n);

			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
