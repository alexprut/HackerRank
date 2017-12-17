/*
       *
NULL <-2--> <-4--> <-6--> NULL
              *
NULL <--2-> <-4--> <-6--> NULL
                     *
NULL <--2-> <--4-> <-6--> NULL
                           *
NULL <--2-> <--4-> <--6-> NULL
*/
/*
   Reverse a doubly linked list, input list may also be empty
   Node is defined as
   struct Node
   {
     int data;
     Node *next;
     Node *prev;
   }
*/
Node* Reverse(Node* head)
{
    while (head != NULL) {
        Node *tmp = head->next;
        head->next = head->prev;
        head->prev = tmp;
        if (head->prev == NULL) { return head; }
        head = head->prev;
    }

    return head;
}
