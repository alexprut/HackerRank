import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

  // Complete the twoArrays function below.
  static String twoArrays(int k, int[] A, int[] B) {
    Arrays.sort(A);
    Arrays.sort(B);
    for (int i = 0; i < A.length; i++) {
      if (A[i] + B[B.length - 1 - i] < k) {
        return "NO";
      }
    }

    return "YES";
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int qItr = 0; qItr < q; qItr++) {
      String[] nk = scanner.nextLine().split(" ");

      int n = Integer.parseInt(nk[0]);

      int k = Integer.parseInt(nk[1]);

      int[] A = new int[n];

      String[] AItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < n; i++) {
        int AItem = Integer.parseInt(AItems[i]);
        A[i] = AItem;
      }

      int[] B = new int[n];

      String[] BItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < n; i++) {
        int BItem = Integer.parseInt(BItems[i]);
        B[i] = BItem;
      }

      String result = twoArrays(k, A, B);

      bufferedWriter.write(result);
      bufferedWriter.newLine();
    }

    bufferedWriter.close();

    scanner.close();
  }
}
