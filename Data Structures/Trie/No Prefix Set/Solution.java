import java.io.*;
import java.util.*;

class TrieNode {
  public char c;
  public TrieNode parent = null;
  public boolean isEndWordNode = false;
  public HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();

  public TrieNode(char c, TrieNode parent) {
    this.c = c;
    this.parent = parent;
  }

  public TrieNode(char c, TrieNode parent, boolean isEndWordNode) {
    this.c = c;
    this.isEndWordNode = isEndWordNode;
    this.parent = parent;
  }
}

class Trie {
  public TrieNode root = new TrieNode(' ', null);

  public String add(String word) {
    TrieNode r = root;
    int i = 0;
    while (i < word.length()) {
      if (!r.children.containsKey(word.charAt(i))) {
        r.children.put(word.charAt(i), new TrieNode(word.charAt(i), r));
        r = r.children.get(word.charAt(i));
      } else {
        r = r.children.get(word.charAt(i));
        if (r.isEndWordNode) {  return word; }
      }
      i++;
    }

    if (r.children.size() > 0) {  return word; }

    r.isEndWordNode = true;

    return "";
  }
}

public class Solution {

  public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String invalid = "";
        Trie root = new Trie();
        for (int i = 0; i < n; i++) {
          invalid = root.add(sc.next());
          if (invalid != "") {  break; }
        }

        if (invalid != "") {
          System.out.println("BAD SET");
          System.out.println(invalid);
        } else {
          System.out.println("GOOD SET");
        }
  }
}
