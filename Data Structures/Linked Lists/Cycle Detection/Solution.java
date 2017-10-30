#include <unordered_map>
/*
Detect a cycle in a linked list. Note that the head pointer may be 'NULL' if the list is empty.

A Node is defined as:
    struct Node {
        int data;
        struct Node* next;
    }
*/

bool has_cycle(Node* head) {
    unordered_map<Node*, int> hash;

    while (head != NULL && head->next != NULL) {
        unordered_map<Node*,int>::const_iterator match = hash.find (head);
        if (match != hash.end()) {
            return true;
        }

        hash.insert(make_pair(head, head->data));
        head = head->next;
    }

    return false;
}
