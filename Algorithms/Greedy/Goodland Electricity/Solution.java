import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

  // Complete the pylons function below.
  static int pylons(int k, int[] arr) {
    int counter = 0;
    int index = 0;
    int notCovered = 1;
    int lastAvailable = -1;
    while (index < arr.length) {
      if (arr[index] == 1) {
        lastAvailable = index;
      }

      if (notCovered >= k) {
        if (lastAvailable == -1) {
          return -1;
        }
        notCovered = - (k - 1) + (index - lastAvailable) + 1;
        index++;
        counter++;
        lastAvailable = -1;
      } else if (index == arr.length - 1) {
        if (notCovered > 0) {
          if (lastAvailable != 0) {
            counter++;
          } else {
            return -1;
          }
        }
        index++;
      } else {
        notCovered++;
        index++;
      }
    }
    return counter;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] nk = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nk[0]);

    int k = Integer.parseInt(nk[1]);

    int[] arr = new int[n];

    String[] arrItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int arrItem = Integer.parseInt(arrItems[i]);
      arr[i] = arrItem;
    }

    int result = pylons(k, arr);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
