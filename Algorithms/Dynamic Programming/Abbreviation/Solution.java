import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

  // Complete the abbreviation function below.
  static String abbreviation(String a, String b) {
    if (a.length() < b.length()) {
      return "NO";
    }

    boolean[][] dp = new boolean[a.length() + 1][b.length() + 1];

    for (int i = 0; i <= a.length(); i++) {
      for (int j = 0; j <= b.length(); j++) {
        if (j > i) {
          dp[i][j] = false;
        } else if (i == 0 && j == 0) {
          dp[i][j] = true;
        } else if (j == 0) {
          dp[i][j] = !Character.isUpperCase(a.charAt(i - 1)) && dp[i - 1][j];
        } else if (Character.isUpperCase(a.charAt(i - 1))) {
          boolean tmp = a.charAt(i - 1) == b.charAt(j - 1) && dp[i - 1][j - 1];
          dp[i][j] = tmp;
        } else {
          boolean tmp = (Character.toUpperCase(a.charAt(i - 1)) == b.charAt(j - 1)) && dp[i - 1][j - 1];
          boolean tmp2 = (tmp || dp[i - 1][j]);
          dp[i][j] = tmp2;
        }
      }
    }

    return dp[a.length()][b.length()] ? "YES" : "NO";
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int qItr = 0; qItr < q; qItr++) {
      String a = scanner.nextLine();

      String b = scanner.nextLine();

      String result = abbreviation(a, b);

      bufferedWriter.write(result);
      bufferedWriter.newLine();
    }

    bufferedWriter.close();

    scanner.close();
  }
}
