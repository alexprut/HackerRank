import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the kaprekarNumbers function below.
    static void kaprekarNumbers(int p, int q) {
        boolean found = false;
        for (int i = p; i <= q; i++) {
            if (isKaprekar(i)) {
                System.out.print("" + i + " ");
                found = true;
            }
        }
        if (!found) {
            System.out.print("INVALID RANGE");
        }
    }

    static boolean isKaprekar(long n) {
        long square = n * n;
        String l = "" + n;
        String tmp = "" + square;
        int diff = tmp.length() - l.length();
        long right = Long.parseLong(tmp.substring(diff));
        if (tmp.length() == l.length()) {
            return n == right;
        }
        long left = Long.parseLong(tmp.substring(0, diff));
        return (right + left) == n;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        kaprekarNumbers(p, q);

        scanner.close();
    }
}
