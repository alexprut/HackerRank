import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static BigInteger candies(int n, int[] arr) {
        int[] cache = new int[arr.length];
        cache[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1] < arr[i]) {
                cache[i] = cache[i-1] + 1;
            }

            if (arr[i-1] >= arr[i]) {
                cache[i] = 1;
            }
        }

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i+1]) {
                if (cache[i] <= cache[i+1]) {
                    cache[i] = cache[i+1] + 1;
                }
            }
        }

        BigInteger sum = BigInteger.valueOf(0);
        for (int i = 0; i < cache.length; i++) {
            sum = sum.add(BigInteger.valueOf(cache[i]));
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        BigInteger result = candies(n, arr);
        System.out.println(result);
        in.close();
    }
}
