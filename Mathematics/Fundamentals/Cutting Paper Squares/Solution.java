import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

  static BigInteger solve(int n, int m){
    if (n == 1 && m == 1) { return new BigInteger("0"); }
    if (n == 1) { return new BigInteger(Integer.toString(m - 1)); }
    if (m == 1) { return new BigInteger(Integer.toString(n - 1)); }
    BigInteger result =  new BigInteger(Integer.toString(n - 1));
    return result.add(new BigInteger(Integer.toString(n)).multiply(new BigInteger(Integer.toString(m - 1))));
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    BigInteger result = solve(n, m);
    System.out.println(result);
  }
}
