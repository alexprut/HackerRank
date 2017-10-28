/*
The structure of the node is

typedef struct node
{
    int freq;
    char data;
    node * left;
    node * right;

}node;

*/


char decode_huff_next_char(node *n, string &s) {
        if (n->data != '\0') { return n->data; }
        if (s[0] == '0') {
        s = s.substr(1, s.length());
        return decode_huff_next_char(n->left, s);
        }

        s = s.substr(1, s.length());
        return decode_huff_next_char(n->right, s);
        }

        void decode_huff(node *root, string s) {
        while (s.length() > 0) {
        cout << decode_huff_next_char(root, s);
        }
        }
