import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer, Integer> heap = new TreeMap<Integer, Integer>();
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0, N = sc.nextInt(); i < N; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                int x = sc.nextInt();
                stack.push(x);
                if (heap.containsKey(x)) {
                    heap.put(x, heap.get(x) + 1);
                } else {
                    heap.put(x, 1);
                }
            } else if (type == 2) {
                int x = stack.pop();
                if (heap.get(x) == 1) {
                    heap.remove(x);
                } else {
                    heap.put(x, heap.get(x) - 1);
                }

            } else {
                if (heap.size() > 0) {
                    System.out.println(heap.lastKey());
                }
            }
        }
    }
}
