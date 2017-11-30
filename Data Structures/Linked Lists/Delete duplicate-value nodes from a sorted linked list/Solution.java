/*
Node is defined as
  class Node {
     int data;
     Node next;
  }
*/

Node RemoveDuplicates(Node head) {
  Node current = head;
    if (head == null) { return null; }
  while (current.next != null) {
      if (current.data == current.next.data) {
          current.next = current.next.next;
      } else {
          current = current.next;
      }
  }

  return head;
}
