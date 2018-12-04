import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

  // Complete the printShortestPath function below.
  static void printShortestPath(int n, int i_start, int j_start, int i_end, int j_end) {
    class Entry {
      int i; int j; String s; int c;
      Entry (int i, int j, String s, int c) {
        this.i = i;
        this.j = j;
        this.s = s;
        this.c = c;
      }
    }

    boolean[][] visited = new boolean[n][n];
    LinkedList<Entry> queue = new  LinkedList<Entry>();
    queue.add(new Entry(i_start, j_start, "", 0));
    visited[i_start][j_start] = true;
    while (!queue.isEmpty()) {
      Entry current = queue.removeFirst();
      if (current.i == i_end && current.j == j_end) {
        System.out.println(current.c);
        System.out.println(current.s);
        return;
      }

      int ul_i = current.i - 2;
      int ul_j = current.j - 1;

      int ur_i = current.i - 2;
      int ur_j = current.j + 1;

      int r_i = current.i;
      int r_j = current.j + 2;

      int lr_i = current.i + 2;
      int lr_j = current.j + 1;

      int ll_i = current.i + 2;
      int ll_j = current.j - 1;

      int l_i = current.i;
      int l_j = current.j - 2;

      if (ul_i >= 0 && ul_j >= 0 && !visited[ul_i][ul_j]) {
        queue.add(new Entry(ul_i, ul_j, current.s + "UL ", current.c + 1));
        visited[ul_i][ul_j] = true;
      }

      if (ur_i >= 0 && ur_j < n && !visited[ur_i][ur_j]) {
        queue.add(new Entry(ur_i, ur_j, current.s + "UR ", current.c + 1));
        visited[ur_i][ur_j] = true;
      }

      if (r_j < n && !visited[r_i][r_j]) {
        queue.add(new Entry(r_i, r_j, current.s + "R ", current.c + 1));
        visited[r_i][r_j] = true;
      }

      if (lr_i < n && lr_j < n && !visited[lr_i][lr_j]) {
        queue.add(new Entry(lr_i, lr_j, current.s + "LR ", current.c + 1));
        visited[lr_i][lr_j] = true;
      }

      if (ll_i < n && ll_j >= 0 && !visited[ll_i][ll_j]) {
        queue.add(new Entry(ll_i, ll_j, current.s + "LL ", current.c + 1));
        visited[ll_i][ll_j] = true;
      }

      if (l_j >= 0 && !visited[l_i][l_j]) {
        queue.add(new Entry(l_i, l_j, current.s + "L ", current.c + 1));
        visited[l_i][l_j] = true;
      }
    }

    System.out.println("Impossible");
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    String[] i_startJ_start = scanner.nextLine().split(" ");

    int i_start = Integer.parseInt(i_startJ_start[0]);

    int j_start = Integer.parseInt(i_startJ_start[1]);

    int i_end = Integer.parseInt(i_startJ_start[2]);

    int j_end = Integer.parseInt(i_startJ_start[3]);

    printShortestPath(n, i_start, j_start, i_end, j_end);

    scanner.close();
  }
}
