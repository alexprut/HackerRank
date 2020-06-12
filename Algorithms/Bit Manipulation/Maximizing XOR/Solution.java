import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int r = sc.nextInt();

		int max = 0;
		for (int i = l; i <= r; i++) {
			for (int j = i; j <= r; j++) {
				max = Math.max(i^j, max);
			}
		}

		System.out.println(max);
	}
}