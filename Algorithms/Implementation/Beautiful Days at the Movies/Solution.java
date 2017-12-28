import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int beautifulDays(int i, int j, int k) {
        int counter = 0;
        for (int v = i; v <= j; v++) {
            int reverse = Integer.parseInt(new StringBuilder(Integer.toString(v)).reverse().toString());
            if (Math.abs(v - reverse) % k == 0) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        int j = in.nextInt();
        int k = in.nextInt();
        int result = beautifulDays(i, j, k);
        System.out.println(result);
        in.close();
    }
}
