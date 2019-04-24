import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	static int minSteps(int n, String B){
		int counter = 0;
		int i = 2;
		while (i < B.length()) {
			String current = B.substring(i-2, i+1);
			if (current.equals("010")) {
				counter++;
				i += 3;
			} else {
				i++;
			}
		}

		return counter;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String B = in.next();
		int result = minSteps(n, B);
		System.out.println(result);
	}
}
