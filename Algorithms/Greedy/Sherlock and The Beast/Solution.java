/**
 3 6 9 12 ...
 5 10 15 20 ...

 z = 5*i + 3*j

 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

  // Complete the decentNumber function below.
  static void decentNumber(int n) {
    int z = n;
    while (z % 3 != 0) {
      z -= 5;
    }
    if (z < 0) {
      System.out.println("-1");
    } else {
      StringBuilder result = new StringBuilder();
      for (int i = 0; i < z; i++) {
        result.append(5);
      }
      for (int i = 0; i < n - z; i++) {
        result.append(3);
      }
      System.out.println(result.toString());
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, t).forEach(tItr -> {
      try {
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        decentNumber(n);
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
  }
}
