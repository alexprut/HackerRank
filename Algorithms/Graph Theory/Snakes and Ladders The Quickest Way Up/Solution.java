import java.io.*;
import java.util.*;

class Pair {
    int p, c;
    Pair (int f, int s) {
        this.p = f;
        this.c = s;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] board = new int[100];

        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < 100; i++) {
                board[i] = Integer.MAX_VALUE;
            }
            HashMap<Integer, Integer> ladders = new HashMap<Integer, Integer>();
            HashMap<Integer, Integer> snakes = new HashMap<Integer, Integer>();
            int N = sc.nextInt();
            for (int n = 0; n < N; n++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                ladders.put(x - 1, y - 1);
            }
            int M = sc.nextInt();
            for (int n = 0; n < M; n++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                snakes.put(x - 1, y - 1);
            }

            LinkedList<Pair> queue = new LinkedList<Pair>();
            board[0] = 0;
            queue.addFirst(new Pair(0, 0));

            while (queue.size() > 0) {
                Pair current = queue.pollLast();

                if (current.c == board[current.p]) {
                    current.c++;
                    for (int i = 1; i <= 6 && current.p + i < 100; i++) {
                        int tmpP = current.p + i;
                        if (ladders.containsKey(tmpP)) { tmpP = ladders.get(tmpP); }
                        if (snakes.containsKey(tmpP)) { tmpP = snakes.get(tmpP); }
                        if (current.c < board[tmpP]) {
                            board[tmpP] = current.c;
                            queue.addFirst(new Pair(tmpP, current.c));
                        }
                    }
                }
            }

            if (board[99] == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(board[99]);
            }
        }
    }
}
