import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String s = scan.nextLine();

    String[] result = s.trim().split("[ !,?._'@]+");

    if (s.trim().equals("")) {
      System.out.println("0");
    } else {
      System.out.println(result.length);
    }
    for (String aResult : result) {
      System.out.println(aResult);
    }

    scan.close();
  }
}

