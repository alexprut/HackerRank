import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            q.add(tmp);
        }

        int counter = 0;
        while (q.size() > 1 && q.peek() <= k) {
            int first = q.poll();
            int second = q.poll();
            q.add(first + 2 * second);
            counter++;
        }

        if (q.peek() < k) {
            System.out.println(-1);
        } else {
            System.out.println(counter);
        }
    }
}
