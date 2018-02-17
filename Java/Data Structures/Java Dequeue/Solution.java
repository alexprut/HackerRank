import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<Integer>();
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        int n = in.nextInt();
        int m = in.nextInt();
        int counter = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            if (i < m) {
                deque.addLast(num);
                if (hash.get(num) != null) {
                    hash.put(num, hash.get(num) + 1);
                } else {
                    hash.put(num, 1);
                }
            } else {
                if (counter < hash.size()) { counter = hash.size(); }
                int first = deque.removeFirst();
                deque.addLast(num);

                if (hash.containsKey(first)) {
                    if (hash.get(first) > 1) {
                        hash.put(first, hash.get(first) - 1);
                    } else {
                        hash.remove(first);
                    }
                }

                if (hash.containsKey(num)) {
                    hash.put(num, hash.get(num) + 1);
                } else {
                    hash.put(num, 1);
                }
            }
        }

        if (counter < hash.size()) {
            counter = hash.size();
        }

        System.out.println(counter);
    }
}
