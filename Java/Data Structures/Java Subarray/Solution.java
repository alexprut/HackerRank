import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int n = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            a[i] = tmp;
        }
        sc.close();

        int counter = 0;
        for (int i = 1; i <= n; i++) {

            int tmpCounter = 0;
            for (int k = 0; k < i; k++) {
                tmpCounter += a[k];
            }

            if (tmpCounter < 0) { counter++; }

            for (int j = i; j < n; j++) {
                tmpCounter += a[j];
                tmpCounter -= a[j-i];
                if (tmpCounter < 0) {
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }
}
