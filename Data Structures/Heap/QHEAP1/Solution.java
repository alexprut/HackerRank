import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeSet<Integer> t = new TreeSet<Integer>();

        for (int i = 0; i < n; i++) {
            int value;
            int command = sc.nextInt();

            if (command == 1) {
                value = sc.nextInt();
                t.add(value);
            } else if (command == 2) {
                value = sc.nextInt();
                t.remove(value);
            } else if (command == 3) {
                System.out.println(t.first());
            }
        }
    }
}
