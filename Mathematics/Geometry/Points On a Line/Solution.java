import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean xb = true, yb = true;
        int x = in.nextInt();
        int y = in.nextInt();
        for(int i = 1; i < n; i++){
            int tmpx = in.nextInt();
            int tmpy = in.nextInt();

            if (x != tmpx) { xb = false; }
            if (y != tmpy) { yb = false; }

            if (!xb && !yb) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
