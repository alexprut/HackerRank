import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    public static TreeSet<Integer> set = new TreeSet<>();
    public static HashMap<String, Boolean> map = new HashMap<>();

    // Complete the stones function below.
    static int[] stones(int n, int a, int b) {
        map.clear();
        set.clear();
        if (n == 0) {
            return new int[] {};
        }
        compute(0, a, b, n-1);
        compute(0, a, b, n-1);
        int[] result = new int[set.size()];
        int i = 0;
        while (set.size() > 0) {
            result[i] = set.pollFirst();
            i++;
        }
        return result;
    }

    public static void compute(int num, int a, int b, int n) {
        if (map.containsKey("" + num + "," + n)) {
            return;
        }

        if (n == 0) {
            set.add(num);
            return;
        } else {
            map.put("" + num + "," + n, true);
        }

        compute(num + b, a, b, n-1);
        compute(num + a, a, b, n-1);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int a = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int b = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = stones(n, a, b);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
