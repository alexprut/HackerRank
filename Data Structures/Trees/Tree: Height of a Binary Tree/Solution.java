/*
class Node
    int data;
    Node left;
    Node right;
*/

static int height(Node root) {
        if (root == null) { return 0; }
        int height = 0;
        Stack<AbstractMap.SimpleEntry<Node, Integer>> s = new Stack<AbstractMap.SimpleEntry<Node, Integer>>();
        s.push(new AbstractMap.SimpleEntry<Node, Integer>(root, 0));
        while (!s.empty()) {
        AbstractMap.SimpleEntry<Node, Integer> current = s.pop();
        if (current.getValue() > height) { height = current.getValue(); }
        if (current.getKey().left != null) {
        s.push(new AbstractMap.SimpleEntry<Node, Integer>(current.getKey().left, current.getValue() + 1));
        }
        if (current.getKey().right != null) {
        s.push(new AbstractMap.SimpleEntry<Node, Integer>(current.getKey().right, current.getValue() + 1));
        }
        }

        return height;
        }


