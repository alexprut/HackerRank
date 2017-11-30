/*
  Merge two linked lists
  head pointer input could be NULL as well for empty list
  Node is defined as
  class Node {
     int data;
     Node next;
  }
*/

Node mergeLists(Node headA, Node headB) {
    Node head = null;
    Node current = null;
    if (headA == null) { return headB; }
    if (headB == null) { return headA; }
    if (headB == null && headA == null) { return head; }

    if (headA.data > headB.data) {
        head = headB;
        headB = headB.next;
    } else {
        head = headA;
        headA = headA.next;
    }
    current = head;

    while (headA != null || headB != null) {
        if (headA == null) {
            current.next = headB;
            current = current.next;
            headB = headB.next;
        } else if (headB == null) {
            current.next = headA;
            current = current.next;
            headA = headA.next;
        } else {
            if (headA.data > headB.data) {
                current.next = headB;
                current = current.next;
                headB = headB.next;
            } else {
                current.next = headA;
                current = current.next;
                headA = headA.next;
            }
        }
    }

    return head;
}
