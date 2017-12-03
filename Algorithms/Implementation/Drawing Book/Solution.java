import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int solve(int n, int p){
        int start = 0;
        int end = (n % 2 == 0) ? n : n - 1;
        int normalizedP = (p % 2 == 0) ? p : p - 1;

        return Math.min((start + normalizedP) / 2, (end - normalizedP) / 2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int result = solve(n, p);
        System.out.println(result);
    }
}
