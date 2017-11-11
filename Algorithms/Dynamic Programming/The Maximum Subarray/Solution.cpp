#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int maxSubArray(int arr[], int n) {
  int maxSoFar = INT8_MIN;
  int maxEnding = INT8_MIN;
  for (int i = 0; i < n; i++) {
    maxEnding = max(maxEnding + arr[i], arr[i]);
    maxSoFar = max(maxSoFar, maxEnding);
  }

  return maxSoFar;
}

int maxSubsequence(int arr[], int n) {
  int maxSoFar = INT8_MIN;
  int sum = 0;
  for (int i = 0; i < n; i++) {
    maxSoFar = max(maxSoFar, arr[i]);
    if (arr[i] > 0) {
      sum += arr[i];
    }
  }

  if (sum == 0) { return maxSoFar; }
  return sum;
}

int main() {
  int T;
  cin >> T;
  for (int t = 0; t < T; t++) {
    int n;
    cin >> n;
    int arr[n];
    for (int i = 0; i < n; i++) { cin >> arr[i]; }
    cout << maxSubArray(arr, n);
    cout << " " << maxSubsequence(arr, n);
    cout << "\n";
  }
  return 0;
}
