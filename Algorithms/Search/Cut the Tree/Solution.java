import java.io.*;
import java.util.*;

public class Solution {
    public static Integer[] data;
    public static Integer[] cache;
    public static Integer[] parent;
    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> children;

    public static int dfs(int s) {
        int counter = cache[s];
        if (!visited[s]) {
            visited[s] = true;
            for (int i = 0; i < children.get(s).size(); i++) {
                int child = children.get(s).get(i);
                if (!visited[child]) {
                    counter += dfs(child);
                }
            }
            cache[s] = counter;
        }
        return counter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        data = new Integer[n];
        parent = new Integer[n];
        cache = new Integer[n];
        visited = new boolean[n];
        children = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
            cache[i] = data[i];
            children.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            u--;
            int v = sc.nextInt();
            v--;
            children.get(u).add(v);
            children.get(v).add(u);
        }

        dfs(0);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            min = Math.min(min, Math.abs(cache[0] - cache[i] - cache[i]));
        }

        System.out.println(min);
    }
}