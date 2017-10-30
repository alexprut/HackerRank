#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <unordered_map>
using namespace std;

struct TrieNode {
  string value;
  unordered_map<char, TrieNode *> children = {};
  int size = 0;
};

class Trie {
 public:
  TrieNode *root = new TrieNode;

  TrieNode *find(string query);

  int countPartialFind(string query);

  void add(string value);

 private:
  void add(string value, TrieNode *node);

  TrieNode *createNewNode(string &value, int counter, unordered_map<char, TrieNode *> &children);

  void add(string value, int counter, TrieNode *node);

  TrieNode *findNode(char query, unordered_map<char, TrieNode *> &children);
};

TrieNode *Trie::find(string value) {
  TrieNode *tmpNode = root;
  for (int counter = 0; counter < value.length(); counter++) {
    tmpNode = findNode(value[counter], tmpNode->children);
    if (tmpNode == NULL) {
      return NULL;
    }
  }

  return tmpNode;
}

int Trie::countPartialFind(string query) {
  TrieNode *matchNode = find(query);
  if (matchNode == NULL) {
    return 0;
  }

  return matchNode->size;
}

void Trie::add(string value, int counter, TrieNode *node) {
  for (; counter < value.length(); counter++) {
    node->size++;
    TrieNode *tmpNode = findNode(value[counter], node->children);
    if (tmpNode == NULL) {
      node = createNewNode(value, counter, node->children);
    } else {
      node = tmpNode;
    }
  }
  node->size++;
}

TrieNode *Trie::findNode(char query, unordered_map<char, TrieNode *> &children) {
  unordered_map<char, TrieNode *>::const_iterator search = children.find(query);
  if (search == children.end()) {
    return NULL;
  }
  return search->second;
}

TrieNode *Trie::createNewNode(string &value, int counter, unordered_map<char, TrieNode *> &children) {
  TrieNode *newNode = new TrieNode;
  newNode->value = value.substr(0, counter + 1);
  char tmp = value[counter];
  children[tmp] = newNode;
  return newNode;
}

void Trie::add(string value) {
  if (value.length() == 0) { return; }
  add(value, 0, root);
}

int main() {
    Trie *t = new Trie;

    int nr;
    cin >> nr;
    while (nr > 0) {
        string query, value;
        cin >> query >> value;

        if (query == "add") {
            t->add(value);
        }
        if(query == "find") {
            cout << t->countPartialFind(value) << "\n";
        }
        nr--;
    }
    return 0;
}
