/*
  Reverse a linked list and return pointer to the head
  The input list will have at least one element
  Node is defined as
  class Node {
     int data;
     Node next;
  }
*/
    // This is a "method-only" submission.
    // You only need to complete this method.
Node Reverse(Node head) {
    Node h = null, next = null;

    while (head != null) {
        next = head.next;
        if (h == null) {
            h = head;
            h.next = null;
        } else {
            head.next = h;
            h = head;
        }

        head = next;
    }

    return h;
}
