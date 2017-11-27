import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int cache[] = new int[26];
        String s = sc.nextLine();
        for (int i = 0; i < s.length(); i++) {
            int tmp = (int) s.charAt(i);
            if (65 <= tmp && tmp <= 90) {
                tmp += 32;
            }

            if (97 <= tmp && tmp <= 122) {
                cache[tmp - 97]++;
            }
        }

        boolean pangram = true;
        for (int i = 0; i < 26; i++) {
            if (cache[i] == 0) { pangram = false; }
        }

        if (pangram) {
            System.out.println("pangram");
        } else {
            System.out.println("not pangram");
        }
    }
}
