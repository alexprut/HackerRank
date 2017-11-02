import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Solution {

    public static BigInteger sum_n_big(String n) {
        BigInteger sd = BigInteger.valueOf(0);
        for (int i = 0; i < n.length(); i++) {
            sd = sd.add(
                BigInteger.valueOf(
                    Character.getNumericValue(n.charAt(i))
                )
            );
        }
        return sd;
    }

    public static BigInteger super_digit(String n) {
        if (n.length() == 1) { return BigInteger.valueOf(Character.getNumericValue(n.charAt(0))); }
        return super_digit(sum_n_big(n).toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        int k = sc.nextInt();
        BigInteger sd = sum_n_big(n);
        sd = sd.multiply(BigInteger.valueOf(k));
        sd = super_digit(sd.toString());
        System.out.println(sd);
    }
}
