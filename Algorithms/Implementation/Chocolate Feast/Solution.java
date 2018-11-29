/**
 n=10 c=2 m=5
 10/2 = 5 = 1 => 6

 12 4 4
 12/4=3

 6 2 2
 6/2=3/2=1
 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

  // Complete the chocolateFeast function below.
  static int chocolateFeast(int n, int c, int m) {
    int counter = n / c;
    int wrappers = counter; // 3
    while (wrappers >= m) { // 3 > 2
      int tmp = wrappers / m;
      counter += tmp;
      wrappers = wrappers - (tmp * m) + tmp;
    }

    return counter;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int t = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int tItr = 0; tItr < t; tItr++) {
      String[] ncm = scanner.nextLine().split(" ");

      int n = Integer.parseInt(ncm[0]);

      int c = Integer.parseInt(ncm[1]);

      int m = Integer.parseInt(ncm[2]);

      int result = chocolateFeast(n, c, m);

      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();
    }

    bufferedWriter.close();

    scanner.close();
  }
}
