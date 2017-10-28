/*

 class Node
    int data;
    Node left;
    Node right;
*/
   void levelOrder(Node root) {
           LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while (queue.size() > 0) {
        Node current = queue.poll();
        if (current != null) {
        System.out.print(current.data + " ");
        queue.add(current.left);
        queue.add(current.right);
        }
        }
        }
