import java.io.*;
import java.util.*;

class Operation {
    public int command;
    public String value;

    public Operation (int c, String v) {
        command = c;
        value = v;
    }
}

public class Solution {

    public static void main(String[] args) {
        String S = "";
        Stack<Operation> s = new Stack<Operation>();
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        for (int i = 0; i < Q; i++) {
            String W;
            int k;
            int command = sc.nextInt();
            if (command == 1) {
                W = sc.next();
                S += W;
                s.push(new Operation(1, W));
            } else if (command == 2) {
                k = sc.nextInt();
                String tmp = S.substring(S.length()-k);
                S = S.substring(0, S.length()-k);
                s.push(new Operation(2, tmp));
            } else if (command == 3) {
                k = sc.nextInt() - 1;
                System.out.println(S.charAt(k));
            } else if (command == 4) {
                Operation tmp = s.pop();
                if (tmp.command == 1) {
                    S = S.substring(0, S.length()-tmp.value.length());
                } else if (tmp.command == 2) {
                    S += tmp.value;
                }
            }
        }
    }
}
