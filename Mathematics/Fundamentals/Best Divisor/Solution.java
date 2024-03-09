import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**

 */

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        bufferedReader.close();

        int maxSum = 0;
        int currentBest = 0;
        ArrayList<Integer> divs = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                divs.add(i);
            }
        }
        for (int i = 0; i < divs.size(); i++) {
            if (sumDigits(divs.get(i)) == maxSum) {
                if (divs.get(i) < currentBest) {
                    currentBest = divs.get(i);
                }
            } else if (sumDigits(divs.get(i)) > maxSum) {
                maxSum = sumDigits(divs.get(i));
                currentBest = divs.get(i);
            }
        }

        System.out.println(currentBest);
    }

    public static int sumDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
