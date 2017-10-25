import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            int size, tmp;
            size = sc.nextInt();
            arr.add(new ArrayList<Integer>());
            for (int j = 0; j < size; j++) {
                tmp = sc.nextInt();
                arr.get(i).add(tmp);
            }
        }

        int q;
        q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int x, y;
            x = sc.nextInt()-1;
            y = sc.nextInt()-1;
            try {
                System.out.println(arr.get(x).get(y));
            } catch (Exception e) {
                System.out.println("ERROR!");
            }
        }
    }
}
