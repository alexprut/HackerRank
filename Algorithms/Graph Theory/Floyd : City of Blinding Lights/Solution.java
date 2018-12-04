import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

  private static final Scanner scanner = new Scanner(System.in);

  public static int[][] floydWarshall(int roadNodes, int[] roadFrom, int[] roadTo,
      int[] roadWeight) {
    int[][] adj = new int[roadNodes][roadNodes];
    for (int i = 0; i < roadNodes; i++) {
      for (int j = 0; j < roadNodes; j++) {
        if (i == j) {
          adj[i][j] = 0;
        } else {
          adj[i][j] = Integer.MAX_VALUE;
        }
      }
    }
    for (int i = 0; i < roadFrom.length; i++) {
      adj[roadFrom[i] - 1][roadTo[i] - 1] = roadWeight[i];
    }

    for (int k = 0; k < roadNodes; k++) {
      int[][] tmp = new int[roadNodes][roadNodes];
      for (int i = 0; i < roadNodes; i++) {
        for (int j = 0; j < roadNodes; j++) {
          int tmpValue =
              (adj[i][k] == Integer.MAX_VALUE || adj[k][j] == Integer.MAX_VALUE) ? Integer.MAX_VALUE
                  : adj[i][k] + adj[k][j];
          tmp[i][j] = Math.min(adj[i][j], tmpValue);
        }
      }
      adj = tmp;
    }

    return adj;
  }

  public static void main(String[] args) {
    String[] roadNodesEdges = scanner.nextLine().split(" ");
    int roadNodes = Integer.parseInt(roadNodesEdges[0].trim());
    int roadEdges = Integer.parseInt(roadNodesEdges[1].trim());

    int[] roadFrom = new int[roadEdges];
    int[] roadTo = new int[roadEdges];
    int[] roadWeight = new int[roadEdges];

    for (int i = 0; i < roadEdges; i++) {
      String[] roadFromToWeight = scanner.nextLine().split(" ");
      roadFrom[i] = Integer.parseInt(roadFromToWeight[0].trim());
      roadTo[i] = Integer.parseInt(roadFromToWeight[1].trim());
      roadWeight[i] = Integer.parseInt(roadFromToWeight[2].trim());
    }

    int[][] dp = floydWarshall(roadNodes, roadFrom, roadTo, roadWeight);

    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int qItr = 0; qItr < q; qItr++) {
      String[] xy = scanner.nextLine().split(" ");

      int x = Integer.parseInt(xy[0]) - 1;
      int y = Integer.parseInt(xy[1]) - 1;
      if (dp[x][y] == Integer.MAX_VALUE) {
        System.out.println(-1);
      } else {
        System.out.println(dp[x][y]);
      }
    }

    scanner.close();
  }
}
