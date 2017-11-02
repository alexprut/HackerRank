import java.io.*;
import java.util.*;
import java.lang.Math;

class Pair {
    public int accumulator;
    public int lastNumber;
    public Pair(int a, int l) {
        accumulator = a;
        lastNumber = l;
    }

}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        Stack<Pair> stack = new Stack<Pair>();
        stack.push(new Pair(0, 1));
        int counter = 0;

        while (!stack.empty()) {
            Pair tmp = stack.pop();
            int i = tmp.lastNumber;
            while (Math.pow(i, n) + tmp.accumulator <= x) {
                if (Math.pow(i, n) + tmp.accumulator == x) {
                    counter++;
                    break;
                } else {
                    stack.push(new Pair((int)Math.pow(i, n) + tmp.accumulator, i + 1));
                }
                i++;
            }
        }

        System.out.print(counter);
    }
}
