import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        List l = new LinkedList();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            l.add(sc.nextInt());
        }
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            String command = sc.next();
            if (command.equals("Insert")) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                l.add(x, y);
            } else if (command.equals("Delete")) {
                int x = sc.nextInt();
                l.remove(x);
            }
        }

        Iterator it = l.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}
