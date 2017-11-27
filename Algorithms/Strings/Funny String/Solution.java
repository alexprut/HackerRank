import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String funnyString(String s){
        String r = (new StringBuffer(s)).reverse().toString();
        for (int i = 1; i < s.length(); i++) {
            if (Math.abs(((int)s.charAt(i)) - ((int)s.charAt(i-1))) != Math.abs(((int)r.charAt(i)) - ((int)r.charAt(i-1)))) {
                return "Not Funny";
            }
        }
        return "Funny";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            String result = funnyString(s);
            System.out.println(result);
        }
    }
}
