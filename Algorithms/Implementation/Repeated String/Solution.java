import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

  // Complete the repeatedString function below.
  static long repeatedString(String s, long n) {
    long counter = 0;
    if (s.length() > n) {
      for (int i = 0; i< n; i++) {
        if (s.charAt(i) == 'a') {
          counter++;
        }
      }
      return counter;
    }
    long as = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'a') {
        as++;
      }
    }

    long maxSeq = n / s.length();
    counter = maxSeq * as;
    int remaining = (int)(n - maxSeq * s.length());
    for (int i = 0; i < remaining; i++) {
      if (s.charAt(i) == 'a') {
        counter++;
      }
    }

    return counter;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String s = scanner.nextLine();

    long n = scanner.nextLong();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    long result = repeatedString(s, n);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
