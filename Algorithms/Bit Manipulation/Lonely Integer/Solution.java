import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	static int lonelyinteger(int[] a) {
		int tmp = a[0];
		for (int i = 1; i < a.length; i++) {
			tmp ^= a[i];
		}
		return tmp;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for(int a_i = 0; a_i < n; a_i++){
			a[a_i] = in.nextInt();
		}
		int result = lonelyinteger(a);
		System.out.println(result);
	}
}
