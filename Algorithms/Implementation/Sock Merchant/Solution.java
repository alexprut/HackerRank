import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int sockMerchant(int n, int[] ar) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        int counter = 0;
        for (int i = 0; i < ar.length; i++) {
            if (set.contains(ar[i])) {
                counter++;
                set.remove(ar[i]);
            } else {
                set.add(ar[i]);
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = sockMerchant(n, ar);
        System.out.println(result);
    }
}
