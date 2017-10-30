/*
  Find merge point of two linked lists
  head pointer input could be NULL as well for empty list
  Node is defined as
  class Node {
     int data;
     Node next;
  }
*/

int lengthNode(Node n) {
    int counter = 0;

    while (n != null) {
        counter++;
        n = n.next;
    }

    return counter;
}

int FindMergeNode(Node headA, Node headB) {
    int lA = lengthNode(headA);
    int lB = lengthNode(headB);
    int d = Math.abs(lA - lB);

    if (lA > lB) {
        for (int i = 0; i < d; i++) {
            headA = headA.next;
        }
    } else if (lA < lB) {
        for (int i = 0; i < d; i++) {
            headB = headB.next;
        }
    }

    while (headA.data != headB.data) {
        headA = headA.next;
        headB = headB.next;
    }

    return headA.data;
}
