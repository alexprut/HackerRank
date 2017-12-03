import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static void bonAppetit(int n, int k, int b, int[] ar) {
        int counter = 0;
        for (int i = 0; i < n; i++) {
            if (i != k) { counter += ar[i]; }
        }

        if (b <= (counter / 2)) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println(b - (counter / 2));
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int b = in.nextInt();
        bonAppetit(n, k, b, ar);
    }
}
