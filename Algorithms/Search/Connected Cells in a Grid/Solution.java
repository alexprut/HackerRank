import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    public int i,j;
    public Node(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public static boolean isValid(int i, int j, int n, int m) {
        return (0 <= i && i < n && 0 <= j && j < m);
    }
}

public class Solution {

    public static int[][] dfs(int[][] adj, int i, int j, int n, int m) {
        Stack<Node> s = new Stack<Node>();
        int counter = 0;
        s.push(new Node(i ,j));

        while (!s.empty()) {
            counter++;
            Node t = s.pop();
            if (adj[t.i][t.j] < counter) { adj[t.i][t.j] = counter; }

            if (Node.isValid(t.i-1, t.j-1, n, m) && adj[t.i-1][t.j-1] == 0) {
                adj[t.i-1][t.j-1] = counter;
                s.push(new Node(t.i-1, t.j-1));
            }
            if (Node.isValid(t.i-1, t.j, n, m) && adj[t.i-1][t.j] == 0) {
                adj[t.i-1][t.j] = counter;
                s.push(new Node(t.i-1, t.j));
            }
            if (Node.isValid(t.i-1, t.j+1, n, m) && adj[t.i-1][t.j+1] == 0) {
                adj[t.i-1][t.j+1] = counter;
                s.push(new Node(t.i-1, t.j+1)); }
            if (Node.isValid(t.i, t.j-1, n, m) && adj[t.i][t.j-1] == 0) {
                adj[t.i][t.j-1] = counter;
                s.push(new Node(t.i, t.j-1)); }
            if (Node.isValid(t.i, t.j+1, n, m) && adj[t.i][t.j+1] == 0) {
                adj[t.i][t.j+1] = counter;
                s.push(new Node(t.i, t.j+1)); }
            if (Node.isValid(t.i+1, t.j-1, n, m) && adj[t.i+1][t.j-1] == 0) {
                adj[t.i+1][t.j-1] = counter;
                s.push(new Node(t.i+1, t.j-1)); }
            if (Node.isValid(t.i+1, t.j, n, m) && adj[t.i+1][t.j] == 0) {
                adj[t.i+1][t.j] = counter;
                s.push(new Node(t.i+1, t.j)); }
            if (Node.isValid(t.i+1, t.j+1, n, m) && adj[t.i+1][t.j+1] == 0) {
                adj[t.i+1][t.j+1] = counter;
                s.push(new Node(t.i+1, t.j+1)); }
        }

        adj[i][j] = counter;
        return adj;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] adj = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int tmp = sc.nextInt();
                if (tmp == 1) {
                    adj[i][j] = 0;
                } else {
                    adj[i][j] = -1;
                }
            }
        }

        int counter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (adj[i][j] == 0) {
                    adj = Solution.dfs(adj, i, j, n, m);
                    if (adj[i][j] > counter) {
                        counter = adj[i][j];
                    }
                }
            }
        }

        System.out.println(counter);
    }
}