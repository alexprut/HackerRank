import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

  // Complete the minimumDistances function below.
  static int minimumDistances(int[] a) {
    int min = Integer.MAX_VALUE;
    HashMap<Integer, Integer> dp = new HashMap<>();
    for (int i = 0; i < a.length; i++) {
      if (dp.containsKey(a[i])) {
        min = Math.min(
            min,
            i - dp.get(a[i])
        );
      } else {
        dp.put(a[i], i);
      }
    }

    return (min == Integer.MAX_VALUE) ? -1 : min;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] a = new int[n];

    String[] aItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int aItem = Integer.parseInt(aItems[i]);
      a[i] = aItem;
    }

    int result = minimumDistances(a);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
