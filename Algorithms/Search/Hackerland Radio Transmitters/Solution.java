import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int hackerlandRadioTransmitters(int[] x, int k) {
        Arrays.sort(x);
        int counter = 0;
        int i = 0;
        while (i < x.length) {
            counter++;
            int leftStartingPoint = i;
            while((i + 1 < x.length) && (x[i + 1] - x[leftStartingPoint] <= k)) { i++; }
            int middlePoint = i;
            while((i + 1 < x.length) && (x[i + 1] - x[middlePoint] <= k)) { i++; }
            i++;
        }

        return counter;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        for(int x_i = 0; x_i < n; x_i++){
            x[x_i] = in.nextInt();
        }
        int result = hackerlandRadioTransmitters(x, k);
        System.out.println(result);
        in.close();
    }
}
