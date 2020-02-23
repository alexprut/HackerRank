   /* Class node is defined as :
    class Node
       int val;   //Value
       int ht;      //Height
       Node left;   //Left child
       Node right;   //Right child

   */

static Node insert(Node root,int val) {
    Node newNode = new Node();
    newNode.val = val;
    newNode.ht = 0;
    newNode.left = null;
    newNode.right = null;

    if (root==null) {
        root = newNode;
    } else {
        root=avlinsert(newNode, root);
    }

    return root;
}

// return height of tree rooted at x
static public int height(Node x) {
    if (x == null) return -1;
    else return x.ht;
}

static public Node rotatewithleft(Node c) {
    Node p;  // left child of c

    p = c.left;
    c.left = p.right;
    p.right = c;

    c.ht = Math.max(height(c.left), height(c.right)) + 1;
    p.ht = Math.max(height(p.left), height(p.right)) + 1;

    return p;
}

static public Node rotatewithright(Node c) {
    Node p;  // right child of c

    p = c.right;
    c.right = p.left;
    p.left = c;

    c.ht = Math.max(height(c.left), height(c.right)) + 1;
    p.ht = Math.max(height(p.left), height(p.right)) + 1;

    return p;
}

static public Node doublerotatewithleft(Node c) {
    Node tmp;

    c.left = rotatewithright(c.left);
    tmp = rotatewithleft(c);

    return tmp;
}

static public Node doublerotatewithright(Node c) {
    Node tmp;

    c.right = rotatewithleft(c.right);
    tmp = rotatewithright(c);

    return tmp;
}

static public Node avlinsert(Node newNode, Node par) {
   Node newpar = par;  // root of subtree par

    if (newNode.val < par.val)  {
        if (par.left == null) {
            par.left = newNode;  //attach new node as leaf
        }
    else {
         par.left = avlinsert(newNode, par.left);   // branch left
         if ((height(par.left) - height(par.right)) == 2) {
            if (newNode.val < par.left.val) {
                newpar=rotatewithleft(par);
            } else {
                newpar=doublerotatewithleft(par);
            } //else
         } //if
      } // else
   } // if
    else if (newNode.val > par.val) { // branch right
        if (par.right == null) {
            par.right = newNode;   // attach new node as leaf
        } else {
            par.right = avlinsert(newNode, par.right);  // branch right
            if ((height(par.right) - height(par.left)) == 2) {
                if (newNode.val > par.right.val) {
                    newpar=rotatewithright(par);
                } //if
                else {
                    newpar=doublerotatewithright(par);
                } //else
            } //if
        } //else
    }  // else if

    // Update the height, just in case

    if ((par.left == null) && (par.right != null))
        par.ht = par.right.ht + 1;
    else if ((par.right == null) && (par.left != null))
        par.ht = par.left.ht + 1;
    else
        par.ht = Math.max(height(par.left), height(par.right)) + 1;

    return newpar; // return new root of this subtree
 }
