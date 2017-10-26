import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static Hashtable<Integer, BigInteger> cache = new Hashtable<Integer, BigInteger>();

    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        Integer t1 = sc.nextInt();
        Integer t2 = sc.nextInt();
        Integer n = sc.nextInt();

        Solution.cache.put(0, BigInteger.valueOf(0));
        Solution.cache.put(1, BigInteger.valueOf(t1));
        Solution.cache.put(2, BigInteger.valueOf(t2));

        System.out.println(Solution.fibonaci(n));
    }

    public static BigInteger fibonaci(Integer n) {
        if (Solution.cache.containsKey(n)) {
            return Solution.cache.get(n);
        }

        BigInteger b1 = Solution.fibonaci(n-2);
        BigInteger b2 = Solution.fibonaci(n-1);
        b2 = b2.pow(2);
        b2 = b2.add(b1);

        return  b2;
    }
}
