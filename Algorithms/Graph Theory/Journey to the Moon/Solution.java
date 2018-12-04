import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

  static int dfs(ArrayList<ArrayList<Integer>> adj, int start, int[] visited) {
    Stack<Integer> stack = new Stack<>();
    stack.push(start);
    int counter = 0;
    visited[start] = 1;
    while (!stack.empty()) {
      int node = stack.pop();
      counter++;
      for (int i = 0; i < adj.get(node).size(); i++) {
        if (visited[adj.get(node).get(i)] == 0) {
          stack.push(adj.get(node).get(i));
          visited[adj.get(node).get(i)] = 1;
        }
      }
    }

    return counter;
  }

  // Complete the journeyToMoon function below.
  static long journeyToMoon(int n, int[][] astronaut) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }
    for (int i = 0; i < astronaut.length; i++) {
      adj.get(astronaut[i][0]).add(astronaut[i][1]);
      adj.get(astronaut[i][1]).add(astronaut[i][0]);
    }
    int[] visited = new int[n];
    ArrayList<Integer> country = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (visited[i] == 0) {
        country.add(dfs(adj, i, visited));
      }
    }

    if (country.size() < 2) {
      return 0;
    }

    long counter = 0;
    long sum = 0;
    for (int i = 1; i < country.size(); i++) {
      sum += country.get(i-1);
      counter += sum * country.get(i);
    }

    return counter;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] np = scanner.nextLine().split(" ");

    int n = Integer.parseInt(np[0]);

    int p = Integer.parseInt(np[1]);

    int[][] astronaut = new int[p][2];

    for (int i = 0; i < p; i++) {
      String[] astronautRowItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int j = 0; j < 2; j++) {
        int astronautItem = Integer.parseInt(astronautRowItems[j]);
        astronaut[i][j] = astronautItem;
      }
    }

    long result = journeyToMoon(n, astronaut);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
