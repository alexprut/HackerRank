import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int max = 0;
        for(int height_i=0; height_i < n; height_i++){
            int tmp = in.nextInt();
            max = Math.max(max, tmp);
        }

        System.out.println(Math.max(0, max - k));
    }
}
