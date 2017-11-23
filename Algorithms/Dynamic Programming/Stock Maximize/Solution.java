import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }

            int maximum = arr[n-1];
            long counter = 0;
            for (int i = n - 2; i >= 0; i--) {
                if (maximum > arr[i]) {
                    counter += maximum - arr[i];
                } else {
                    maximum = arr[i];
                }
            }
            System.out.println(counter);
        }
        in.close();
    }
}
