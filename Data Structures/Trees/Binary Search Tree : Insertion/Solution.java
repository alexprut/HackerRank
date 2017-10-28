/* Node is defined as :
class Node
   int data;
   Node left;
   Node right;

   */

static Node Insert(Node root, int value) {
        if (root == null) {
        root = new Node();
        root.data = value;
        return root;
        }

        boolean inserted = false;
        Node current = root;
        Node newNode = new Node();
        newNode.data = value;

        while (!inserted) {
        if (current.data < value) {
        if (current.right == null) {
        current.right = newNode;
        inserted = true;
        } else {
        current = current.right;
        }
        } else {
        if (current.left == null) {
        current.left = newNode;
        inserted = true;
        } else {
        current = current.left;
        }
        }
        }

        return root;
        }


