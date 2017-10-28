import java.io.*;
import java.util.*;

class PairEntry implements Comparable<PairEntry>{
    public int value;
    public int index;
    public PairEntry(int v, int i) {
        value = v;
        index = i;
    }

    public int compareTo(PairEntry b) {
        return (this.value >= b.value) ? 1: -1;
    }
}

class Pair{
    public int first;
    public int second;
    public Pair(int f, int s) {  first = f; second = s; }
}

public class Solution {

    public static Pair find(int m, ArrayList<PairEntry> arr) {
        Collections.sort(arr);
        Pair result = new Pair(-1, -1);
        int i = 0, j = arr.size() - 1;
        while (i != j && (arr.get(i).value + arr.get(j).value != m)) {
            if (arr.get(i).value + arr.get(j).value > m) {
                j--;
            } else {
                i++;
            }
        }

        result.first = Math.min(arr.get(i).index, arr.get(j).index) + 1;
        result.second = Math.max(arr.get(i).index, arr.get(j).index) + 1;

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            ArrayList<PairEntry> arr = new ArrayList<PairEntry>();
            for (int j = 0; j < n; j++) {
                arr.add(j, new PairEntry(sc.nextInt(), j));
            }
            Pair result = Solution.find(m, arr);
            System.out.println(result.first + " " + result.second);
        }
    }
}