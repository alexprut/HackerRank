	/*

    class Node
    	int data;
    	Node left;
    	Node right;
	*/
	public static void topView(Node root) {
    class Pair {
      Node n;
      int p;

      Pair(Node n, int p) {
        this.n = n;
        this.p = p;
      }
    }

    int[] values = new int[500 + 1];
    for (int i = 0; i < 500 + 1; i++) {
      values[i] = -1;
    }
    LinkedList<Pair> queue = new LinkedList<>();
    queue.push(new Pair(root, 250));

    while (!queue.isEmpty()) {
      Pair current = queue.pop();

      if (values[current.p] == -1) {
        values[current.p] = current.n.data;
      }

      if (current.n.left != null) {
        queue.add(new Pair(current.n.left, current.p - 1));
      }

      if (current.n.right != null) {
        queue.add(new Pair(current.n.right, current.p + 1));
      }
    }

    for (int i = 0; i < 500 + 1; i++) {
      if (values[i] != -1) {
        System.out.print(values[i] + " ");
      }
    }
  }
