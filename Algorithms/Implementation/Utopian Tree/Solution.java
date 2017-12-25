import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int N = sc.nextInt();
            int value = 1;
            for (int j = 0; j < N; j++) {
                if (j % 2 == 0) {
                    value = value * 2;
                } else {
                    value++;
                }
            }
            System.out.println(value);
        }
    }
}
