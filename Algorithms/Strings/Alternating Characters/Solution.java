/**
 AAB -> AB
 ABAA -> ABA
 BAAB -> AB
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	static int alternatingCharacters(String s){
		int counter = 0;
		int i = 1; int j = 1;
		while (i < s.length()) {
			j = i;
			if (s.charAt(i-1) != s.charAt(i)) {
				i++;
			} else {
				while (j < s.length() && s.charAt(i-1) == s.charAt(j)) {
					j++;
					counter++;
				}
				i = j;
			}
		}

		return counter;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for(int a0 = 0; a0 < q; a0++){
			String s = in.next();
			int result = alternatingCharacters(s);
			System.out.println(result);
		}
	}
}
