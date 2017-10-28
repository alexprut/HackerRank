import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String solve(int[] a, int sum){
        String result = "NO";
        int left = 0;
        int right = sum;
        for (int i = 0; i < a.length; i++) {
            right -= a[i];
            if (i - 1 >= 0) { left += a[i-1]; }
            if (right == left) { return "YES"; }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            int n = in.nextInt();
            int sum = 0;
            int[] a = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
                sum += a[a_i];
            }
            String result = solve(a, sum);
            System.out.println(result);
        }
    }
}
