import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  static int findDigits(int n) {
    String number = "" + n;
    int counter = 0;
    for (int i = 0; i < number.length(); i++) {
      int tmp = Character.getNumericValue(number.charAt(i));
      if (tmp != 0) {
        counter = (n % tmp == 0) ? counter + 1 : counter;
      }
    }

    return counter;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for (int a0 = 0; a0 < t; a0++) {
      int n = in.nextInt();
      int result = findDigits(n);
      System.out.println(result);
    }
    in.close();
  }
}
