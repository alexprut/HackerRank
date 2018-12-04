import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

  // Complete the longestCommonSubsequence function below.
  static int[] longestCommonSubsequence(int[] a, int[] b) {
    ArrayList<Integer>[][] dp = new ArrayList[a.length + 1][b.length + 1];
    for (int i = 0; i < a.length + 1; i++) {
      for (int j = 0; j < b.length + 1; j++) {
        dp[i][j] = new ArrayList<Integer>();
      }
    }

    for (int i = 1; i < a.length + 1; i++) {
      for (int j = 1; j < b.length + 1; j++) {
        if (a[i - 1] == b[j - 1]) {
          ArrayList<Integer> tmp = (ArrayList<Integer>) dp[i - 1][j - 1].clone();
          tmp.add(a[i - 1]);
          dp[i][j] = tmp;
        } else {
          ArrayList<Integer> tmp = dp[i - 1][j - 1];
          if (tmp.size() < dp[i - 1][j].size()) {
            tmp = dp[i - 1][j];
          }
          if (tmp.size() < dp[i][j - 1].size()) {
            tmp = dp[i][j - 1];
          }

          dp[i][j] = (ArrayList<Integer>) tmp.clone();
        }
      }
    }

    int[] result = new int[dp[a.length][b.length].size()];
    for (int i = 0; i < dp[a.length][b.length].size(); i++) {
      result[i] = dp[a.length][b.length].get(i);
    }
    return result;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] nm = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nm[0]);

    int m = Integer.parseInt(nm[1]);

    int[] a = new int[n];

    String[] aItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int aItem = Integer.parseInt(aItems[i]);
      a[i] = aItem;
    }

    int[] b = new int[m];

    String[] bItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < m; i++) {
      int bItem = Integer.parseInt(bItems[i]);
      b[i] = bItem;
    }

    int[] result = longestCommonSubsequence(a, b);

    for (int i = 0; i < result.length; i++) {
      bufferedWriter.write(String.valueOf(result[i]));

      if (i != result.length - 1) {
        bufferedWriter.write(" ");
      }
    }

    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
