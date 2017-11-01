import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String super_reduced_string(String s){
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                String left = (i-1 < 0) ? "" : s.substring(0, i);
                String right = (i+2 >= s.length()) ? "" : s.substring(i+2, s.length());
                return super_reduced_string(left + right);
            }
        }

        return s;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string(s);
        if (result.equals("")) {
            System.out.println("Empty String");
        } else
            System.out.println(result);

    }
}
