#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

int main() {
  int n, q;
  cin >> n >> q;
  vector<vector<int>> a;
  for (int i = 0; i < n; ++i) {
    int k;
    cin >> k;
    vector<int> innerA;
    for (int j = 0; j < k; ++j) {
      int tmp;
      cin >> tmp;
      innerA.push_back(tmp);
    }
    a.push_back(innerA);
  }
  for (int l = 0; l < q; ++l) {
    int i, j;
    cin >> i >> j;
    cout << a[i][j] << "\n";
  }
  return 0;
}
