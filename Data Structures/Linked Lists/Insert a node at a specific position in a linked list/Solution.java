/*
  Insert Node at a given position in a linked list
  head can be NULL
  First element in the linked list is at position 0
  Node is defined as
  class Node {
     int data;
     Node next;
  }
*/

/**
(1, 0) -> null

*/

Node InsertNth(Node head, int data, int position) {
    Node current = head;
    Node prev = head;
    int counter = 0;
    Node node = new Node();
    node.data = data;
    if (head != null && position == 0) {
        node.next = head;
        return node;
    }
    if (head == null) { return node; }
    while (counter < position && current.next != null) {
        prev = current;
        current = current.next;
        counter++;
    }

    if (counter != position) {
        current.next = node;
    } else {
        prev.next = node;
        node.next = current;
    }

    return head;
}
