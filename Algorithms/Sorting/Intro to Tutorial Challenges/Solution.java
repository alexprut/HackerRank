import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            if (sc.nextInt() == v) {
                System.out.println(i);
                break;
            }
        }
    }
}
