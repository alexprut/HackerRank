/*
  Delete Node at a given position in a linked list
  Node is defined as
  struct Node
  {
     int data;
     struct Node *next;
  }
*/
Node* Delete(Node *head, int position)
{
    if (head == NULL) { return NULL; }
    if (position == 0) { return head->next; }

    Node* current = head;
    Node* previous = NULL;

    for (int i = 0; i < position; i++) {
        previous = current;
        current = current->next;
    }

    previous->next = current->next;
    return head;
}
