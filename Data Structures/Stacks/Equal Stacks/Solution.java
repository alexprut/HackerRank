import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int h1[] = new int[n1];
        for(int h1_i=0; h1_i < n1; h1_i++){
            h1[h1_i] = in.nextInt();
        }
        int h2[] = new int[n2];
        for(int h2_i=0; h2_i < n2; h2_i++){
            h2[h2_i] = in.nextInt();
        }
        int h3[] = new int[n3];
        for(int h3_i=0; h3_i < n3; h3_i++){
            h3[h3_i] = in.nextInt();
        }

        HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
        int acc = 0;
        for (int i = n1 - 1; i >= 0; i--) {
            acc += h1[i];
            cache.put(acc, 1);
        }

        acc = 0;
        for (int i = n2 - 1; i >= 0; i--) {
            acc += h2[i];
            if (cache.containsKey(acc)) {
                cache.put(acc, cache.get(acc) + 1);
            }
        }

        acc = 0;
        int max = 0;
        for (int i = n3 - 1; i >= 0; i--) {
            acc += h3[i];
            if (cache.containsKey(acc) && cache.get(acc) == 2) {
                max = acc;
            }
        }

        System.out.println(max);
    }
}
