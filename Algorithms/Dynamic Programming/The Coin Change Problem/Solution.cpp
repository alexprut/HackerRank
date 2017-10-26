#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

long long int counter(vector<int> &coins, int m, int n, vector<vector<long long int>> &cache) {
  if (n == 0) { return 1; }
  if (n < 0 || m < 0) { return 0; }
  if (cache[m][n] != -1) { return cache[m][n]; }
  return counter(coins, m - 1, n, cache) + counter(coins, m, n - coins[m], cache);
}

int main() {
  int N, M;
  cin >> N >> M;
  vector<int> coins;
  vector<vector<long long int>> cache(M, vector<long long int>(N+1, -1));
  for (int i = 0; i < M; i++) {
    int tmp;
    cin >> tmp;
    coins.push_back(tmp);
  }

  for (int i = 0; i < M; i++) {
    cache[i][0] = 1;
  }

  for (int i = 0; i < M; i++) {
    for (int j = 1; j <= N; j++) {
      cache[i][j] = counter(coins, i, j, cache);
    }
  }

  cout << cache[M - 1][N];

  return 0;
}
