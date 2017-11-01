import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int makingAnagrams(String s1, String s2){
        int[] cache = new int[100];
        int counter = 0;
        for (int i = 0; i < s1.length(); i++) {
            cache[Character.getNumericValue(s1.charAt(i))]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            cache[Character.getNumericValue(s2.charAt(i))]--;
        }

        for (int i = 0; i < 100; i++) {
            counter += Math.abs(cache[i]);
        }

        return counter;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int result = makingAnagrams(s1, s2);
        System.out.println(result);
    }
}
