import java.io.*;
import java.util.*;

public class Solution {
  public static int[] nodesCounter;
  public static boolean[] visited;
  public static ArrayList<ArrayList<Integer>> adj;
  public static Integer[] parent;

  public static int dfs(int s) {
    if (!visited[s]) {
      visited[s] = true;
      nodesCounter[s] = 1;
      for (int i = 0; i < adj.get(s).size(); i++) {
        int child = adj.get(s).get(i);
        if (!visited[child]) {
            parent[child] = s;
            nodesCounter[s] += dfs(child);
        }
      }
    }

    return nodesCounter[s];
  }

    public static int getRoot(int s) {
        if (parent[s] != null) {
            return getRoot(parent[s]);
        }

        return s;
    }

    public static void substractUntilRoot(int s, int value) {
        nodesCounter[s] -= value;
        if (parent[s] != null) {
            substractUntilRoot(parent[s], value);
        }
    }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    visited = new boolean[N];
    nodesCounter = new int[N];
    parent = new Integer[N];
    adj = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i < N; i++) { adj.add(new ArrayList<Integer>()); }

    for (int i = 0; i < N - 1; i++) {
      int u = sc.nextInt();
      int v = sc.nextInt();
      u--; v--;
      adj.get(u).add(v);
      adj.get(v).add(u);
    }

    dfs(0);

    int counterRemovals = 0;
    for (int i = 1; i < N; i++) { visited[i] = false; }
    for (int i = 1; i < N; i++) {
        int root = getRoot(i);
        if (root != i) {
            if (nodesCounter[i] % 2 == 0 && nodesCounter[root] % 2 == 0) {
                substractUntilRoot(parent[i], nodesCounter[i]);
                counterRemovals++;
            }
        }
    }

    System.out.println(counterRemovals);
  }
}
