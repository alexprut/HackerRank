import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int i = n - 3;
        while (i >= 0 && arr[i] + arr[i+1] <= arr[i+2]) {
            i--;
        }

        if (i >= 0) {
            System.out.println(arr[i] + " " + arr[i+1] + " " + arr[i+2]);
        } else {
            System.out.println(-1);
        }
    }
}
