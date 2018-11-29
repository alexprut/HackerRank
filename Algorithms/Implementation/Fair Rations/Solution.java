/**
 4 5 6 7
 4 6 7 7
 4 6 8 8
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

  // Complete the fairRations function below.
  static int fairRations(int[] B) {
    int sum = 0;
    for (int i = 0; i < B.length; i++) {
      sum += B[i];
    }
    if (sum % 2 != 0) {
      return -1;
    }
    int counter = 0;
    for (int i = 0; i < B.length - 1; i++) {
      if (B[i] % 2 != 0) {
        B[i]++;
        B[i+1]++;
        counter += 2;
      }
    }
    return counter;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int N = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] B = new int[N];

    String[] BItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < N; i++) {
      int BItem = Integer.parseInt(BItems[i]);
      B[i] = BItem;
    }

    int result = fairRations(B);

    if (result == -1) {
      bufferedWriter.write("NO");
    } else {
      bufferedWriter.write(String.valueOf(result));
    }

    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
