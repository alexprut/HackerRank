/*
  Insert Node at the end of a linked list
  head pointer input could be NULL as well for empty list
  Node is defined as
  struct Node
  {
     int data;
     struct Node *next;
  }
*/
Node* Insert(Node *head,int data)
{
    Node* n = new Node();
    n->data = data;

    if (head == NULL) { return n; }
    Node *current = head;
    while (current->next != NULL) {
        current = current->next;
    }

    current->next = n;
    return head;
}
