import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int counter = 0;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) { arr[i] = sc.nextInt(); }
        Arrays.sort(arr);
        for (int i = 0; i < N - 1; i++) {
            int find = K + arr[i];
            if (Arrays.binarySearch(arr, i + 1, N, find) >= 0) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}