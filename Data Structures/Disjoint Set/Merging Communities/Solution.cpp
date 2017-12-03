#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <unordered_map>
using namespace std;

class DisjointSets {
 public:
  DisjointSets(int n) {
    for (int i = 0; i < n; i++) {
      makeSet(i);
    }
  }

  int findSet(int node) {
    if (parent[node] == node) { return node; }
    parent[node] = findSet(parent[node]);
    return parent[node];
  }

  int unionSets(int firstNode, int secondNode) {
    int firstNodeParent = findSet(firstNode);
    int secondNodeParent = findSet(secondNode);

    if (firstNodeParent == secondNodeParent) {
      return firstNodeParent;
    }

    if (rank[firstNodeParent] > rank[secondNodeParent]) {
      parent[secondNodeParent] = firstNodeParent;
      size[firstNodeParent] += size[secondNodeParent];
      return firstNodeParent;
    }

    parent[firstNodeParent] = secondNodeParent;
    size[secondNodeParent] += size[firstNodeParent];
    if (rank[firstNodeParent] == rank[secondNodeParent]) {
      rank[secondNodeParent] += 1;
    }

    return secondNodeParent;
  }

  int getSize(int node) {
    return size[findSet(node)];
  }

 private:
  unordered_map<int, int> parent;
  unordered_map<int, int> size;
  unordered_map<int, int> rank;

  void makeSet(int elem) {
    parent[elem] = elem;
    size[elem] = 1;
    rank[elem] = 0;
  }
};

int main() {
    int n;
    cin >> n;
    int q;
    cin >> q;
    DisjointSets sets(n + 1);
    for (int i = 0; i < q; i++) {
        char tmp;
        cin >> tmp;
        if (tmp == 'Q') {
            int node;
            cin >> node;
            cout << sets.getSize(node) << "\n";
        } else {
            int nodeFirst;
            int nodeSecond;
            cin >> nodeFirst;
            cin >> nodeSecond;
            sets.unionSets(nodeFirst, nodeSecond);
        }
    }
    return 0;
}
