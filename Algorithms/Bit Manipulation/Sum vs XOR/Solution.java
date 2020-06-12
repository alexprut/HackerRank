import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 5+0=5x0=5
 5+2=5x2=7

 101 = 2^2 + 2^0
 000 = 0
 101 = 5

 101 010 = 111 = 7
 101 001 = 4
 101 011 = 110 = 6


 */

public class Solution {

	// Complete the sumXor function below.
	static long sumXor(long n) {
		if (n == 0) {
			return 1;
		}
		int c = 0;
		String num = Long.toBinaryString(n);
		for (int i = 0; i < num.length(); i++) {
			if (num.charAt(i) == '0') {
				c++;
			}
		}
		return (long) Math.pow(2.0, c);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		long n = Long.parseLong(bufferedReader.readLine().trim());

		long result = sumXor(n);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
