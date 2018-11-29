import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

  // Complete the circularArrayRotation function below.
  static int[] circularArrayRotation(int[] a, int k, int[] queries) {
    k = k % a.length;
    int[] result = new int[queries.length];
    for (int i = 0; i < result.length; i++) {
      result[i] = a[(queries[i] - k + a.length) % a.length];
    }

    return result;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] nkq = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nkq[0]);

    int k = Integer.parseInt(nkq[1]);

    int q = Integer.parseInt(nkq[2]);

    int[] a = new int[n];

    String[] aItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int aItem = Integer.parseInt(aItems[i]);
      a[i] = aItem;
    }

    int[] queries = new int[q];

    for (int i = 0; i < q; i++) {
      int queriesItem = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
      queries[i] = queriesItem;
    }

    int[] result = circularArrayRotation(a, k, queries);

    for (int i = 0; i < result.length; i++) {
      bufferedWriter.write(String.valueOf(result[i]));

      if (i != result.length - 1) {
        bufferedWriter.write("\n");
      }
    }

    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
