import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Stack;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] h = new int[n];
    for(int h_i = 0; h_i < n; h_i++){
      h[h_i] = in.nextInt();
    }

    int maxArea = Integer.MIN_VALUE;
    Stack<Integer> stack = new Stack<Integer>();

    int i = 0;
    int removedIndex;
    for (; i < n; i++) {
      if (stack.empty() || h[stack.peek()] <= h[i]) {
        stack.push(i);
      } else {
        while (!stack.empty() && h[stack.peek()] > h[i]) {
          removedIndex = stack.pop();
          if (stack.empty()) {
            maxArea = Math.max(h[removedIndex] * i, maxArea);
          } else {
            maxArea = Math.max(h[removedIndex] * (i - 1 - stack.peek()), maxArea);
          }
        }
        stack.push(i);
      }
    }

    while (!stack.empty()) {
      removedIndex = stack.pop();
      if (stack.empty()) {
        maxArea = Math.max(h[removedIndex] * i, maxArea);
      } else {
        maxArea = Math.max(h[removedIndex] * (i - 1 - stack.peek()), maxArea);
      }
    }

    System.out.println(maxArea);
    in.close();
  }
}
