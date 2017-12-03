import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int solve(int n, int[] s, int d, int m){
        if (m > n) { return 0; }
        int counter = 0;
        int acc = 0;
        for (int i = 0; i < m; i++) { acc += s[i]; }
        for (int i = m; i < n; i++) {
            if (acc == d) { counter++; }
            acc += s[i];
            acc -= s[i - m];
        }

        if (acc == d) { counter++; }

        return counter;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int d = in.nextInt();
        int m = in.nextInt();
        int result = solve(n, s, d, m);
        System.out.println(result);
    }
}
