#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


struct Node {
    int data;
};

struct BinaryNode : Node {
    BinaryNode *left = NULL;
    BinaryNode *right = NULL;
};

struct DisjointSetNode : Node {
    DisjointSetNode *parent;
    int rank = 0;
    int size = 1;
};

DisjointSetNode *makeSet(int value) {
    DisjointSetNode *node = new DisjointSetNode;
    node->data = value;
    node->parent = node;

    return node;
}

DisjointSetNode *findSet(DisjointSetNode *node) {
    if (node->parent == node) { return node; }
    node->parent = findSet(node->parent);
    return node->parent;
}

DisjointSetNode *unionSets(DisjointSetNode *firstNode, DisjointSetNode *secondNode) {
    DisjointSetNode *firstNodeParent = findSet(firstNode);
    DisjointSetNode *secondNodeParent = findSet(secondNode);

    if (firstNodeParent == secondNodeParent) {
        return firstNodeParent;
    }

    if (firstNodeParent->rank > secondNodeParent->rank) {
        secondNodeParent->parent = firstNodeParent;
        firstNodeParent->size += secondNodeParent->size;
        return firstNodeParent;
    }

    firstNodeParent->parent = secondNodeParent;
    secondNodeParent->size += firstNodeParent->size;
    if (firstNodeParent->rank == secondNodeParent->rank) {
        secondNodeParent->rank += 1;
    }

    return secondNodeParent;
}

int size(DisjointSetNode* node) {
    DisjointSetNode* parent = findSet(node);
    return parent->size;
}

int main() {
    int N;
    cin >> N;
    int MIN = N + 1;
    int MAX = 2;
    vector<DisjointSetNode*> nodes(2*N);
    for (int i = 0; i <= 2*N; i++) {
        nodes[i] = makeSet(i);
    }
    for (int i = 0; i < N; i++) {
        int edge1, edge2;
        cin >> edge1 >> edge2;

        unionSets(nodes[edge1], nodes[edge2]);
    }

    for (int i = 0; i <= 2 * N; i++) {
        int nrOfNodesInSet = findSet(nodes[i])->size;
        if (nrOfNodesInSet > 1) {
            if (nrOfNodesInSet > MAX) { MAX = nrOfNodesInSet; }
            if (nrOfNodesInSet < MIN) { MIN = nrOfNodesInSet; }
        }
    }

    cout << MIN << " " << MAX;

    return 0;
}
