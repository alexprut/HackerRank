import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] count = new int[100];
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            count[tmp]++;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(count[i] + " ");
        }
    }
}
