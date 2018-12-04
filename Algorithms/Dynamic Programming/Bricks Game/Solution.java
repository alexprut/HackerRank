import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

  /*
   * Complete the bricksGame function below.


   [1,3,4,5]
    1 4 8 13
   */
  static long bricksGame(int[] arr) {
    int n = arr.length + 1;
    for (int i = 0; i < arr.length / 2; i++) {
      int tmp = arr[i];
      arr[i] = arr[arr.length - i - 1];
      arr[arr.length - i - 1] = tmp;
    }
    long[] sums = new long[n];
    for (int i = 1; i < n; i++) {
      sums[i] = sums[i - 1] + arr[i - 1];
    }
    long[] dp = new long[n];
    dp[1] = sums[1];
    dp[2] = sums[2];
    dp[3] = sums[3];
    for (int i = 4; i < n; i++) {
      dp[i] = Math.max(
          sums[i] - dp[i - 1],
          Math.max(
              sums[i] - dp[i - 2],
              sums[i] - dp[i - 3]
          )
      );
    }
    return dp[n - 1];
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int t = Integer.parseInt(scanner.nextLine().trim());

    for (int tItr = 0; tItr < t; tItr++) {
      int arrCount = Integer.parseInt(scanner.nextLine().trim());

      int[] arr = new int[arrCount];

      String[] arrItems = scanner.nextLine().split(" ");

      for (int arrItr = 0; arrItr < arrCount; arrItr++) {
        int arrItem = Integer.parseInt(arrItems[arrItr].trim());
        arr[arrItr] = arrItem;
      }

      long result = bricksGame(arr);

      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();
    }

    bufferedWriter.close();
  }
}
