import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> equal = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        int pivot = sc.nextInt();
        equal.add(pivot);
        for (int i = 1; i < n; i++) {
            int tmp = sc.nextInt();
            if (pivot == tmp) {
                equal.add(tmp);
            } else if (tmp < pivot) {
                left.add(tmp);
            } else {
                right.add(tmp);
            }
        }

        for (int i = 0; i < left.size(); i++) {
            System.out.print(left.get(i) + " ");
        }

        for (int i = 0; i < equal.size(); i++) {
            System.out.print(equal.get(i) + " ");
        }

        for (int i = right.size() - 1; i >= 0; i--) {
            System.out.print(right.get(i) + " ");
        }
    }
}
