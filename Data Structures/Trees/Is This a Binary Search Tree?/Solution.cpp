/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.

The Node struct is defined as follows:
   struct Node {
      int data;
      Node* left;
      Node* right;
   }
*/
    bool checkBSTHelper(Node* node, pair<int,int> range) {
       if (node == NULL) { return true; }
       if (node->data < range.first || node->data > range.second) {return false;}

       return
           checkBSTHelper(node->left, make_pair(range.first, node->data-1)) &&
           checkBSTHelper(node->right, make_pair(node->data+1, range.second));
    }

   bool checkBST(Node* root) {
       if (root == NULL) { return true; }

       return
           checkBSTHelper(root->left, make_pair(0, root->data-1)) &&
           checkBSTHelper(root->right, make_pair(root->data+1, 10000));
   }
