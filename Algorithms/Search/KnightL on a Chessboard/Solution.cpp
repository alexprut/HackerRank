#include <map>
#include <set>
#include <list>
#include <cmath>
#include <ctime>
#include <deque>
#include <queue>
#include <stack>
#include <string>
#include <bitset>
#include <cstdio>
#include <limits>
#include <vector>
#include <climits>
#include <cstring>
#include <cstdlib>
#include <fstream>
#include <numeric>
#include <sstream>
#include <iostream>
#include <algorithm>
#include <unordered_map>

using namespace std;

int Knight(int n, int a, int b) {
  vector<vector<int>> cache(n, vector<int>(n, INT_MAX));
  queue<pair<int, int>> q;
  q.push(make_pair(0, 0));
  cache[0][0] = 0;
  while (!q.empty()) {
    pair<int, int> position = q.front();
    q.pop();

    int currentCounter = cache[position.first][position.second] + 1;

    vector<pair<int, int>> nextPositions = {
        make_pair(position.first + a, position.second + b),
        make_pair(position.first - a, position.second + b),
        make_pair(position.first - a, position.second - b),
        make_pair(position.first + a, position.second - b),
        make_pair(position.first + b, position.second + a),
        make_pair(position.first - b, position.second + a),
        make_pair(position.first - b, position.second - a),
        make_pair(position.first + b, position.second - a)
    };

    for (int i = 0; i < nextPositions.size(); i++) {
      pair<int, int> tmp = nextPositions[i];
      int x = tmp.first, y = tmp.second;
      if (0 <= x && x <= n - 1 && 0 <= y && y <= n - 1) {
        if (cache[x][y] > currentCounter) {
          cache[x][y] = currentCounter;
          q.push(make_pair(x, y));
        }
      }
    }
  }


  if (cache[n-1][n-1] == INT_MAX) {
    return -1;
  }

  return cache[n-1][n-1];
}

int main() {
  int n;
  cin >> n;
  for (int i = 1; i < n; i++) {
    for (int j = 1; j < n; j++) {
      cout << Knight(n, i, j) << " ";
    }
    cout << "\n";
  }
  return 0;
}
