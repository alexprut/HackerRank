/*
  Get Nth element from the end in a linked list of integers
  Number of elements in the list will always be greater than N.
  Node is defined as
  class Node {
     int data;
     Node next;
  }
*/

int GetNode(Node head, int n) {
    Stack<Integer> s = new Stack<Integer>();
    while (head != null) {
        s.push(head.data);
        head = head.next;
    }

    while (n > 0) {
        s.pop();
        n--;
    }

    return s.pop();
}
