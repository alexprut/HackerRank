import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] cache = new int[100];
        int min = Integer.MAX_VALUE;
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
            if (A[i] < min) { min = A[i]; }
        }
        int m = sc.nextInt();
        int[] B = new int[m];
        for (int i = 0; i < m; i++) {
            B[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            cache[A[i]-min]++;
        }

        for (int i = 0; i < m; i++) {
            cache[B[i]-min]--;
        }

        for (int i = 0; i < 100; i++) {
            if (cache[i] != 0) {
                System.out.print((min+i) + " ");
            }
        }
    }
}