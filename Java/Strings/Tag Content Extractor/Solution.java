import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    int testCases = Integer.parseInt(in.nextLine());
    while (testCases > 0) {
      String line = in.nextLine();

      boolean found = false;
      Pattern r = Pattern.compile("<(.+)>([^<]+)</\\1>");
      Matcher m = r.matcher(line);

      while (m.find()) {
        found = true;
        System.out.println(m.group(2));
      }

      if (!found) {
        System.out.println("None");
      }

      testCases--;
    }
  }
}



