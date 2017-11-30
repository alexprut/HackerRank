import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Node {
    int value;
    Node left = null;
    Node right = null;

    Node () {}
    Node (int value) { this.value = value; }
}

public class Solution {
    public static Node root;

    public static void inOrderVisit(Node node) {
        if (node != null) {
            Solution.inOrderVisit(node.left);
            System.out.print("" + node.value + " ");
            Solution.inOrderVisit(node.right);
        }
    }

    public static void insert(Node node, int i, int l, int r) {
        if (node != null) {
            if (node.value == i) {
                if (l != -1) { node.left = new Node(l); }
                if (r != -1) { node.right = new Node(r); }
            } else {
                Solution.insert(node.left, i, l, r);
                Solution.insert(node.right, i, l, r);
            }
        }
    }

    public static void swap(Node node, int depth, int k) {
        if (node != null) {
            if (depth % k == 0) {
                Node tmp = node.left;
                node.left = node.right;
                node.right = tmp;
            }
            Solution.swap(node.left, depth + 1, k);
            Solution.swap(node.right, depth + 1, k);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Solution.root = new Node(1);
        for (int i = 1; i <= n; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            Solution.insert(root, i, l, r);
        }

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int k = sc.nextInt();
            Solution.swap(root, 1, k);
            Solution.inOrderVisit(Solution.root);
            System.out.println("");
        }
    }
}
