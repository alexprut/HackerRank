import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int getTotalX(int[] a, int[] b, int maxA, int minB) {
        int counter = 0;

        for (int i = maxA; i <= minB; i++) {
            boolean sentinel = false;
            for (int j = 0; j < a.length; j++) {
                if (i % a[j] != 0) {
                    sentinel = true;
                    break;
                }
            }
            for (int j = 0; j < b.length; j++) {
                if (b[j] % i != 0) {
                    sentinel = true;
                    break;
                }
            }

            if (!sentinel) { counter++; }
        }

        return counter;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int maxA = Integer.MIN_VALUE;
        int minB = Integer.MAX_VALUE;
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            maxA = Math.max(maxA, a[a_i]);
        }
        int[] b = new int[m];
        for(int b_i = 0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
            minB = Math.min(minB, b[b_i]);
        }
        int total = getTotalX(a, b, maxA, minB);
        System.out.println(total);
        in.close();
    }
}
