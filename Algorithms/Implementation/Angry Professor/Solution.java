import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            for (int j = 0; j < n; j++) {
                int tmp = sc.nextInt();
                if (tmp <= 0) { k--;}
            }
            if (k <= 0) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
