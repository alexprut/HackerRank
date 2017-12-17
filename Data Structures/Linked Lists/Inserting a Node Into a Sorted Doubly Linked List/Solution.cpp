/*
    Insert Node in a doubly sorted linked list
    After each insertion, the list should be sorted
   Node is defined as
   struct Node
   {
     int data;
     Node *next;
     Node *prev;
   }
*/
void print(Node *head) {
    while (head != NULL) {
        cout << " " << head->data << " ";
        head = head->next;
    }
    cout << "\n";
}

Node* SortedInsert(Node *head, int data)
{
    Node *node = new Node();
    node->data = data;
    Node *current = head;

    if (head == NULL) {
        return node;
    }
    if (node->data < head->data) {
        node->next = head;
        head->prev = node;
        return node;
    }

    while (current->data < node->data) {
        if (current->next == NULL) {
            current->next = node;
            node->prev = current;
            return head;
        }

        current = current->next;
    }

    node->prev = current->prev;
    node->next = current;
    node->prev->next = node;
    current->prev = node;

    return head;
}
