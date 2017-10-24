import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
    int node;
    int value;
    public Pair(int n, int v) {
        node = n;
        value = v;
    }

    public int compareTo(Pair b) {
        return (value < b.value) ? -1: 1;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>();
        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
        int weight = 0;
        int N, M, S;
        N = sc.nextInt();
        M = sc.nextInt();
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<Pair>());
        }
        for (int i = 0; i < M; i++) {
            int x, y, r;
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
            r = sc.nextInt();
            adj.get(x).add(new Pair(y, r));
            adj.get(y).add(new Pair(x, r));
        }
        S = sc.nextInt() - 1;

        queue.add(new Pair(S, 0));
        while (queue.size() > 0) {
            Pair current = queue.poll();
            if (!visited[current.node]) {
                for (int i = 0; i < adj.get(current.node).size(); i++) {
                    Pair tmp = adj.get(current.node).get(i);
                    if (!visited[tmp.node]) {
                        queue.add(tmp);
                    }
                }

                weight += current.value;
                visited[current.node] = true;
            }
        }

        System.out.println(weight);
    }
}
