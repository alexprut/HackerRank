import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static String getSmallestAndLargest(String s, int k) {
        ArrayList<String> cache = new ArrayList<>();
        for (int i = 0; i <= s.length() - k; i++) {
            cache.add(s.substring(i, i + k));
        }

        Collections.sort(cache);

        String smallest = cache.get(0);
        String largest = cache.get(cache.size() - 1);

        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}
