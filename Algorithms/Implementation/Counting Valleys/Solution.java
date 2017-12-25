import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int level = 0;
        int prevLevel = 0;
        int counter = 0;
        String path = sc.next();
        for (int i = 0; i < path.length(); i++) {
            prevLevel = level;
            if (path.charAt(i) == 'U') {
                level++;
            } else {
                level--;
            }

            if (level == -1 && prevLevel == 0) {
                counter++;
            }
        }

        System.out.println(counter);
    }
}
