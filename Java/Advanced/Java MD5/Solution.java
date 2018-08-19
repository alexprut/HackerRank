import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.security.MessageDigest;

public class Solution {

  private static String convertByteToHex(byte[] byteData) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < byteData.length; i++) {
      sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String word = sc.next();
    MessageDigest md;
    try {
      md = MessageDigest.getInstance("MD5");
      System.out.println(convertByteToHex(md.digest(word.getBytes())));
    } catch (Exception e) { }
  }
}
