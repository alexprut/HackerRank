import java.io.*;
import java.util.*;

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class State {
    Pair p;
    int counter;

    State(Pair position) {
        this.p = position;
        this.counter = 0;
    }

    State(Pair position, int counter) {
        this.p = position;
        this.counter = counter;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            Pair start = new Pair(0, 0), end = new Pair(0, 0);
            int[][] board = new int[N][M];
            for (int j = 0; j < N; j++) {
                String line = sc.next();
                for (int k = 0; k < M; k++) {
                    if (line.charAt(k) == 'X') {
                        board[j][k] = -1;
                    } else if (line.charAt(k) == 'M') {
                        board[j][k] = 0;
                        start = new Pair(j, k);
                    } else if (line.charAt(k) == '*') {
                        board[j][k] = 0;
                        end = new Pair(j, k);
                    }
                }
            }

            int K = sc.nextInt();

            // Solve problem here
            LinkedList<State> queue = new LinkedList<State>();
            queue.addFirst(new State(start));

            while (queue.size() > 0) {
                State current = queue.pollLast();
                Pair p = current.p;
                ArrayList<Pair> nextMove = new ArrayList<Pair>();

                if (p.x == end.x && p.y == end.y) {
                    board[p.x][p.y] = current.counter;
                    break;
                } else {
                    board[p.x][p.y] = -1;
                }

                // Right
                if (p.y + 1 < M && board[p.x][p.y + 1] == 0) {
                    nextMove.add(new Pair(p.x, p.y + 1));
                }

                // Left
                if (p.y - 1 >= 0 && board[p.x][p.y - 1] == 0) {
                    nextMove.add(new Pair(p.x, p.y - 1));
                }

                // Up
                if (p.x - 1 >= 0 && board[p.x - 1][p.y] == 0) {
                    nextMove.add(new Pair(p.x - 1, p.y));
                }

                // Down
                if (p.x + 1 < N && board[p.x + 1][p.y] == 0) {
                    nextMove.add(new Pair(p.x + 1, p.y));
                }

                if (nextMove.size() > 1) {
                    current.counter++;
                }

                for (int g = 0; g < nextMove.size(); g++) {
                    current.p = nextMove.get(g);
                    queue.addFirst(new State(new Pair(current.p.x, current.p.y), current.counter));
                }
            }

            if (board[end.x][end.y] == K) {
                System.out.println("Impressed");
            } else {
                System.out.println("Oops!");
            }
        }
    }
}