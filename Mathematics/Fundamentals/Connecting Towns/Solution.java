import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int result = 0;
            for (int n = 0; n < N -1; n++) {
                if (n == 0) {
                    result = sc.nextInt() % 1234567;
                } else {
                    result = (result * (sc.nextInt() % 1234567)) % 1234567;
                }
            }
            System.out.println(result);
        }
    }
}
