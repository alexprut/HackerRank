#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
  vector<pair<int,int>> result;
  vector<int> numbers;
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int tmp;
    cin >> tmp;
    numbers.push_back(tmp);
  }
  sort(numbers.begin(), numbers.end());

  result.push_back(make_pair(numbers[0], numbers[1]));

  for (int i = 2; i < n; i++) {
    if (abs(numbers[i-1] - numbers[i]) < abs(result[0].first - result[0].second)) {
      result.erase(result.begin(), result.end());
      result.push_back(make_pair(numbers[i-1], numbers[i]));
    } else if (abs(numbers[i-1] - numbers[i]) == abs(result[0].first - result[0].second)) {
      result.push_back(make_pair(numbers[i-1], numbers[i]));
    }
  }

  for (int i = 0; i < result.size(); i++) {
    cout << result[i].first << " " << result[i].second << " ";
  }

  return 0;
}
