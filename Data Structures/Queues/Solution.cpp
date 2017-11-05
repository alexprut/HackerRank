#include <math.h>
#include <iostream>
#include <sstream>
#include <stack>
#include <vector>
#include <iterator>

using namespace std;

bool isEmpty(stack<int> &first, stack<int> &second) {
  return (first.empty() && second.empty());
}

void enqueue(int x, stack<int> &first, stack<int> &second) {
  first.push(x);
}

int dequeue(stack<int> &first, stack<int> &second) {
  if (second.empty()) {
    while (!first.empty()) {
      int tmpValue = first.top();
      first.pop();
      second.push(tmpValue);
    }
  }

  int tmpValue = second.top();
  second.pop();
  return tmpValue;
}

int top(stack<int> &first, stack<int> &second) {
  if (second.empty()) {
    while (!first.empty()) {
      int tmpValue = first.top();
      first.pop();
      second.push(tmpValue);
    }
  }

  return second.top();
}

int main() {
  int queryNumber;
  stack<int> first;
  stack<int> second;
  vector<int> result;
  cin >> queryNumber;

  while (queryNumber >= 0) {
    string s;
    getline(cin, s);
    istringstream is(s);
    vector<int> v((istream_iterator<int>(is)), istream_iterator<int>());

    if (!v.empty()) {
      if (v[0] == 1) {
        enqueue(v[1], first, second);
      } else if (v[0] == 2) {
        dequeue(first, second);
      } else if (v[0] == 3) {
        result.push_back(top(first, second));
      }
    }

    queryNumber--;
  }

  for (int i = 0; i < result.size(); i++) {
    cout << result[i] << "\n";
  }

  return 0;
};
