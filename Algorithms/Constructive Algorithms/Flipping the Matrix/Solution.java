import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int flippingMatrix(int[][] matrix) {
        int counter = 0;
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                counter += Math.max(
                    Math.max(
                        matrix[i][j],
                        matrix[i][j + matrix.length - 1 - 2 * j]
                    ),
                    Math.max(
                        matrix[i + matrix.length - 1 - 2 * i][j],
                        matrix[i + matrix.length - 1 - 2 * i][j + matrix.length - 1 - 2 * j]
                    )
                );
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int[][] matrix = new int[2*n][2*n];
            for(int matrix_i = 0; matrix_i < 2*n; matrix_i++){
                for(int matrix_j = 0; matrix_j < 2*n; matrix_j++){
                    matrix[matrix_i][matrix_j] = in.nextInt();
                }
            }
            int result = flippingMatrix(matrix);
            System.out.println(result);
        }
        in.close();
    }
}
