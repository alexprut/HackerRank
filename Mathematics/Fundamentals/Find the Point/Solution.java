import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        int n, px, py, qx, qy;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            px = sc.nextInt();
            py = sc.nextInt();
            qx = sc.nextInt();
            qy = sc.nextInt();

            System.out.println(((qx-px)+qx) + " " + ((qy-py)+qy));
        }
    }
}
