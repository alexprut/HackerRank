import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

  // Complete the taumBday function below.
  static String taumBday(int b, int w, int bc, int wc, int z) {
    BigInteger c = BigInteger.valueOf(b);
    BigInteger d = BigInteger.valueOf(Math.min(bc, wc + z));
    BigInteger e = BigInteger.valueOf(w);
    BigInteger f = BigInteger.valueOf(Math.min(wc, bc + z));

    return c.multiply(d).add(e.multiply(f)).toString();
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int t = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int tItr = 0; tItr < t; tItr++) {
      String[] bw = scanner.nextLine().split(" ");

      int b = Integer.parseInt(bw[0]);

      int w = Integer.parseInt(bw[1]);

      String[] bcWcz = scanner.nextLine().split(" ");

      int bc = Integer.parseInt(bcWcz[0]);

      int wc = Integer.parseInt(bcWcz[1]);

      int z = Integer.parseInt(bcWcz[2]);

      String result = taumBday(b, w, bc, wc, z);

      bufferedWriter.write(result);
      bufferedWriter.newLine();
    }

    bufferedWriter.close();

    scanner.close();
  }
}
