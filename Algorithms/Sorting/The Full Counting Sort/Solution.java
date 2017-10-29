import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        int[] counter = new int[100];
        String[] s = new String[n];
        String[] orderedS = new String[n];
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
            counter[numbers[i]]++;
            s[i] = sc.next();
        }

        for (int i = 1; i < 100; i++) { counter[i] += counter[i-1]; }

        for (int i = (n-1); i >= 0; i--) {
            if (i < n/2) {
                orderedS[counter[numbers[i]] - 1] = "-";
            } else {
                orderedS[counter[numbers[i]] - 1] = s[i];
            }
            counter[numbers[i]] -= 1;
        }

        for (int i = 0; i < n; i++) {
            out.append(orderedS[i] + " ");
        }

        System.out.print(out);
    }
}
