import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

  // Complete the flatlandSpaceStations function below.
  static int flatlandSpaceStations(int n, int[] c) {
    Arrays.sort(c);
    int max = Integer.MIN_VALUE;
    for (int i = 1; i < c.length; i++) {
      max = Math.max(max, (c[i] - c[i - 1]) / 2);
    }
    max = Math.max(max, c[0]);
    max = Math.max(max, (n - 1 - c[c.length - 1]));
    return max;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] nm = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nm[0]);

    int m = Integer.parseInt(nm[1]);

    int[] c = new int[m];

    String[] cItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < m; i++) {
      int cItem = Integer.parseInt(cItems[i]);
      c[i] = cItem;
    }

    int result = flatlandSpaceStations(n, c);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
