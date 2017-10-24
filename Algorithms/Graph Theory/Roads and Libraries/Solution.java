import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static long solve(int n, long cl, long cr, ArrayList<TreeSet<Integer>> adj) {
        if (cl <= cr) { return (cl * n); }
        long cost = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                long tmpCost = cl;
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                visited[i] = true;
                while (!stack.empty()) {
                    int u = stack.pop();
                    Iterator<Integer> it = adj.get(u).iterator();
                    while (it.hasNext()) {
                        int v = it.next();
                        if (!visited[v]) {
                            stack.push(v);
                            visited[v] = true;
                            tmpCost += cr;
                        }
                    }
                }
                cost += tmpCost;
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            long cl = in.nextLong();
            long cr = in.nextLong();
            ArrayList<TreeSet<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++) { adj.add(new TreeSet<Integer>()); }
            for(int a1 = 0; a1 < m; a1++){
                int u = in.nextInt();
                u--;
                int v = in.nextInt();
                v--;
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            System.out.println(Solution.solve(n, cl, cr, adj));
        }
    }
}
