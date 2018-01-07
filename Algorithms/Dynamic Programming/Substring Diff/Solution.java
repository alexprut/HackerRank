import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  public static void main(String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int t = 0; t < T; t++) {
      int S = sc.nextInt();
      String P = sc.next();
      String Q = sc.next();
      int maxL = 0;

      for (int i = 0; i < P.length() && maxL < P.length() - i; i++) {
        for (int j = 0; j < P.length() && maxL < P.length() - j; j++) {
          int counter = 0;
          int L = 0;
          int I = i;
          int J = j;
          while (I < P.length() && J < P.length()) {
            if (P.charAt(I) != Q.charAt(J)) {
              counter++;
            }

            L++;
            if (counter <= S) {
              maxL = Math.max(maxL, L);
            } else {
              break;
            }

            I++;
            J++;
          }
        }
      }

      System.out.println(maxL);
    }
  }
}
