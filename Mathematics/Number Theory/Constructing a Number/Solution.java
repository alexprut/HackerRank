import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String canConstruct(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            String tmp = Integer.toString(a[i]);
            for (int j = 0; j < tmp.length(); j++) {
                sum += Character.getNumericValue(tmp.charAt(j));
            }
        }

        if (sum % 3 == 0) {
            return "Yes";
        }

        return "No";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] a = new int[n];
            for(int a_i = 0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            String result = canConstruct(a);
            System.out.println(result);
        }
        in.close();
    }
}
