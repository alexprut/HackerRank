import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int anagram(String s){
        if (s.length() % 2 != 0) { return -1; }
        int[] cache = new int[70];

        for (int i = 0; i < s.length() / 2; i++) {
            cache[Character.getNumericValue(s.charAt(i))]++;
        }

        for (int i = s.length() / 2; i < s.length(); i++) {
            if (cache[Character.getNumericValue(s.charAt(i))] > 0) {
                cache[Character.getNumericValue(s.charAt(i))]--;
            }
        }

        int counter = 0;
        for (int i = 0; i < 70; i++) {
            counter += cache[i];
        }

        return counter;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = anagram(s);
            System.out.println(result);
        }
    }
}
