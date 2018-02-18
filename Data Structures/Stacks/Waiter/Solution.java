import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.math.*;

public class Solution {

  public static ArrayList<Integer> findNPrimes(int n) {
    ArrayList<Integer> primes = new ArrayList<Integer>();
    int i = 2;
    while (primes.size() < n) {
      BigInteger tmp = new BigInteger("" + i);
      if (tmp.isProbablePrime(1000)) {
        primes.add(i);
      }
      i++;
    }

    return primes;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int q = in.nextInt();
    Stack<Integer> A = new Stack<Integer>();
    ArrayList<Integer> primes = findNPrimes(q);
    for (int i = 0; i < n; i++) {
      A.push(in.nextInt());
    }

    ArrayList<Stack<Integer>> B = new ArrayList<Stack<Integer>>();
    for (int i = 0; i < q; i++) {
      Stack<Integer> tmpA = new Stack<Integer>();
      Stack<Integer> BI = new Stack<Integer>();
      while (!A.empty()) {
        if (A.peek() % primes.get(i) == 0) {
          BI.push(A.pop());
        } else {
          tmpA.push(A.pop());
        }
      }

      B.add(BI);
      A = tmpA;
    }

    for (int i = 0; i < q; i++) {
      while (!B.get(i).empty()) {
        System.out.println(B.get(i).pop());
      }
    }

    while (!A.empty()) {
      System.out.println(A.pop());
    }
  }
}
