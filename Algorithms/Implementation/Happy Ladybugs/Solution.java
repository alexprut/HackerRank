import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

  // Complete the happyLadybugs function below.
  static String happyLadybugs(String b) {
    b = b.toLowerCase();
    boolean canSwap = false;
    boolean isEmpty = true;
    int[] chars = new int[26];
    for (int i = 0; i < b.length(); i++) {
      if (b.charAt(i) == '_') {
        canSwap = true;
      } else {
        chars[((int) b.charAt(i)) - 97]++;
        isEmpty = false;
      }
    }
    if (isEmpty) {
      return "YES";
    }
    if (b.length() <= 1) {
      return "NO";
    }
    for (int i = 0; i < 26; i++) {
      if (chars[i] == 1) {
        return "NO";
      }
    }
    for (int i = 0; i < b.length(); i++) {
      if (i == 0) {
        if (b.charAt(i) != b.charAt(i + 1) && !canSwap) {
          return "NO";
        }
      } else if (i == b.length() - 1) {
        if (b.charAt(i) != b.charAt(i - 1) && !canSwap) {
          return "NO";
        }
      } else {
        if (b.charAt(i) != b.charAt(i - 1) && b.charAt(i) != b.charAt(i + 1) && !canSwap) {
          return "NO";
        }
      }
    }
    return "YES";
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int g = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int gItr = 0; gItr < g; gItr++) {
      int n = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      String b = scanner.nextLine();

      String result = happyLadybugs(b);

      bufferedWriter.write(result);
      bufferedWriter.newLine();
    }

    bufferedWriter.close();

    scanner.close();
  }
}
