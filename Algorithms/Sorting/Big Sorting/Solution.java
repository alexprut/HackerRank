import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class SortStringsComparator implements Comparator<String> {
    public int compare(String x, String y) {
        if (x.length() == y.length()) {
            return x.compareTo(y);
        }

        return x.length() - y.length();
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder out = new StringBuilder();
        int n = in.nextInt();
        String[] arr = new String[n];
        for(int i=0; i < n; i++){
            arr[i] = in.next();
        }

        Arrays.sort(arr, new SortStringsComparator());

        for (int i = 0; i < arr.length; i++) {
            out.append(arr[i].toString() + "\n");
        }

        System.out.println(out.toString());

    }
}
