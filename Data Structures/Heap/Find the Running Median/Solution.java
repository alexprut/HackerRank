import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
input
[12, 4, 5, 3, 8, 7]

left right
[12] [0]
[4, 12] [0] -> [12] [4] -> [4] [12]
[4, 5] [12]
[3, 4, 5] [12] -> [3, 4] [5, 12]
[3, 4, 8] [5, 12] -> [3, 4, 5] [8, 12]
[3, 4, 5, 7] [8, 12] -> [3, 4, 5] [7, 8, 12]


input [1,2,3,4,5]

left right
[] []
[1] []
[1, 2] [] -> [1] [2]
[1, 3] [2] -> [1, 2] [3]
[1, 2, 4] [3] -> [1, 2] [3, 4]
[1, 2, 5] [3, 4] -> [1, 2, 3] [4, 5]
*/


public class Solution {
    public static void main(String args[] ) throws Exception {
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            left.add(tmp);
            if (left.size() - right.size() > 1) { right.add(left.poll()); }
            if (right.size() != 0 && left.peek() > right.peek()) {
                left.add(right.poll());
                right.add(left.poll());
            }

            double median;
            if (left.size() > right.size()) {
                median = 1.0 * left.peek();
            } else {
                median = (left.peek() + right.peek()) / 2.0;
            }

            System.out.println(median);
        }
    }
}
