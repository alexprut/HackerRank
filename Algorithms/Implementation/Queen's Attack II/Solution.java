import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

  // Complete the queensAttack function below.
  static int queensAttack(int n, int k, int r, int c, int[][] obstacles) {
    HashMap<Integer, HashSet<Integer>> cache = new HashMap<>();
    for (int i = 0; i < obstacles.length; i++) {
      if (cache.containsKey(obstacles[i][0])) {
        cache.get(obstacles[i][0]).add(obstacles[i][1]);
      } else {
        cache.put(obstacles[i][0], new HashSet<Integer>());
        cache.get(obstacles[i][0]).add(obstacles[i][1]);
      }
    }
    int counter = 0;
    // right
    for (int i = c + 1; i <= n; i++) {
      if (cache.containsKey(r) && cache.get(r).contains(i)) {
        break;
      }
      counter++;
    }

    // left
    for (int i = c - 1; i >= 1; i--) {
      if (cache.containsKey(r) && cache.get(r).contains(i)) {
        break;
      }
      counter++;
    }

    // down
    for (int i = r + 1; i <= n; i++) {
      if (cache.containsKey(i) && cache.get(i).contains(c)) {
        break;
      }
      counter++;
    }

    // up
    for (int i = r - 1; i >= 1; i--) {
      if (cache.containsKey(i) && cache.get(i).contains(c)) {
        break;
      }
      counter++;
    }

    // up-left
    for (int i = r - 1, j = c - 1; i >= 1 && j >= 1; i--, j--) {
      if (cache.containsKey(i) && cache.get(i).contains(j)) {
        break;
      }
      counter++;
    }

    // up-right
    for (int i = r - 1, j = c + 1; i >= 1 && j <= n; i--, j++) {
      if (cache.containsKey(i) && cache.get(i).contains(j)) {
        break;
      }
      counter++;
    }

    // down-right
    for (int i = r + 1, j = c + 1; i <= n && j <= n; i++, j++) {
      if (cache.containsKey(i) && cache.get(i).contains(j)) {
        break;
      }
      counter++;
    }

    // down-left
    for (int i = r + 1, j = c - 1; i <= n && j >= 1; i++, j--) {
      if (cache.containsKey(i) && cache.get(i).contains(j)) {
        break;
      }
      counter++;
    }

    return counter;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] nk = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nk[0]);

    int k = Integer.parseInt(nk[1]);

    String[] r_qC_q = scanner.nextLine().split(" ");

    int r_q = Integer.parseInt(r_qC_q[0]);

    int c_q = Integer.parseInt(r_qC_q[1]);

    int[][] obstacles = new int[k][2];

    for (int i = 0; i < k; i++) {
      String[] obstaclesRowItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int j = 0; j < 2; j++) {
        int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
        obstacles[i][j] = obstaclesItem;
      }
    }

    int result = queensAttack(n, k, r_q, c_q, obstacles);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
