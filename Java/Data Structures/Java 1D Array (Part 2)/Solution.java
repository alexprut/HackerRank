import java.util.*;

public class Solution {

  public static boolean canWin(int leap, int[] game) {
    Queue<Integer> stack = new LinkedList<>();
    stack.add(0);

    while (!stack.isEmpty()) {
      int current = stack.poll();
      game[current] = 2;
      if (current + 1 >= game.length || current + leap >= game.length) {
        return true;
      }

      if (game[current + 1] == 0) {
        stack.add(current + 1);
      }

      if (game[current + leap] == 0) {
        stack.add(current + leap);
      }

      if (current - 1 >= 0 && game[current - 1] == 0) {
        stack.add(current - 1);
      }
    }

    return false;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int q = scan.nextInt();
    while (q-- > 0) {
      int n = scan.nextInt();
      int leap = scan.nextInt();

      int[] game = new int[n];
      for (int i = 0; i < n; i++) {
        game[i] = scan.nextInt();
      }

      System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
    }
    scan.close();
  }
}
