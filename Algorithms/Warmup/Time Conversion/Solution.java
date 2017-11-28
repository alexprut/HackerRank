import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  static String timeConversion(String s) {
    DateFormat df = new SimpleDateFormat("hh:mm:ssa");
    Date result = new Date();
    try {
      result =  df.parse(s);
    } catch (Exception e) { }
    DateFormat dr =  new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
    return (String) dr.format(result);
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.next();
    String result = timeConversion(s);
    System.out.println(result);
  }
}
