/**

 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	static int gemstones(String[] arr){
		int cache[] = new int[256];
		int counter = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length(); j++) {
				int tmp = (int) arr[i].charAt(j);
				if (cache[tmp] == i) {
					cache[tmp]++;
				}

				if (cache[tmp] == arr.length) {
					cache[tmp]++;
					counter++;
				}
			}
		}

		return counter;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] arr = new String[n];
		for(int arr_i = 0; arr_i < n; arr_i++){
			arr[arr_i] = in.next();
		}
		int result = gemstones(arr);
		System.out.println(result);
	}
}
