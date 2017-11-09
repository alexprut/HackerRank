import java.io.*;
import java.util.*;
import java.lang.*;

public class Solution {
  public static Hashtable<Integer, Integer> cache;
  public static HashSet<Integer> arr;
  public static int min;

  public static int solve(int k) {
    if (k < min) { return 0; }
    if (cache.containsKey(k)) { return cache.get(k); }
    int max = Integer.MIN_VALUE;
    Iterator<Integer> it = arr.iterator();
    while (it.hasNext()) {
      int current = it.next();
      if (current <= k) {
        max = Math.max(max, solve(k - current) + current);
      }
    }

    cache.put(k, max);

    return max;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++) {
      min = Integer.MAX_VALUE;
      cache = new Hashtable<Integer, Integer>();
      int n = sc.nextInt();
      int k = sc.nextInt();
      arr = new HashSet<Integer>();
      for (int j = 0; j < n; j++) {
        int current = sc.nextInt();
        arr.add(current);
        min = Math.min(min, current);
      }
      System.out.println(solve(k));
    }
  }
}
