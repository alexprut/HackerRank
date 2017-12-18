import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

class Pair implements Comparable<Pair> {

  public int x;
  public int c;

  Pair(int x, int c) {
    this.x = x;
    this.c = c;
  }

  public int compareTo(Pair b) {
    return (b.c < this.c) ? 1 : -1;
  }
}


public class Solution {

  public static ArrayList<HashMap<Integer, Integer>> adj;
  public static int[] shortestPaths;

  public static void dijkstra(int s) {
    shortestPaths = new int[adj.size()];
    for (int i = 0; i < adj.size(); i++) {
      shortestPaths[i] = Integer.MAX_VALUE;
    }
    shortestPaths[s] = 0;
    boolean[] visited = new boolean[adj.size()];
    PriorityQueue<Pair> queue = new PriorityQueue<>();
    queue.add(new Pair(s, 0));

    while (!queue.isEmpty()) {
      Pair current = queue.poll();
      if (!visited[current.x]) {
        visited[current.x] = true;
        Iterator<Map.Entry<Integer, Integer>> entries = adj.get(current.x).entrySet().iterator();

        while (entries.hasNext()) {
          Map.Entry<Integer, Integer> entry = entries.next();
          if (current.c + entry.getValue() < shortestPaths[entry.getKey()]) {
            shortestPaths[entry.getKey()] = current.c + entry.getValue();
            if (!visited[entry.getKey()]) {
              queue.add(new Pair(entry.getKey(), shortestPaths[entry.getKey()]));
            }
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    try {
      int t = Integer.parseInt(in.readLine());
      for (int i = 0; i < t; i++) {
        String[] stmp = in.readLine().split(" ");
        int n = Integer.parseInt(stmp[0]);
        int m = Integer.parseInt(stmp[1]);

        adj = new ArrayList<HashMap<Integer, Integer>>();
        for (int j = 0; j < n; j++) {
          adj.add(new HashMap<>());
        }

        for (int j = 0; j < m; j++) {
          stmp = in.readLine().split(" ");
          int x = Integer.parseInt(stmp[0]);
          int y = Integer.parseInt(stmp[1]);
          int r = Integer.parseInt(stmp[2]);
          x--;
          y--;

          if (!adj.get(x).containsKey(y) || adj.get(x).get(y) > r) {
            adj.get(x).put(y, r);
          }
          if (!adj.get(y).containsKey(x) || adj.get(y).get(x) > r) {
            adj.get(y).put(x, r);
          }
        }

        int s = Integer.parseInt(in.readLine());
        s--;
        dijkstra(s);
        StringBuilder out = new StringBuilder("");
        for (int j = 0; j < n; j++) {
          if (s != j) {
            if (shortestPaths[j] == Integer.MAX_VALUE) {
              out.append("-1 ");
            } else {
              out.append(shortestPaths[j]);
              out.append(" ");
            }
          }
        }
        out.append("\n");
        System.out.print(out.toString());
      }
    } catch (Exception e) {
    }
  }
}
