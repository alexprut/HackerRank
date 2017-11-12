#include <math.h>
#include <algorithm>
#include <ostream>
#include <iostream>

using namespace std;

string kangaroo(int x1, int v1, int x2, int v2) {
  if (x1 == x2) {
    return "YES";
  } else if ((x1 < x2 && v1 > v2) || (x1 > x2 && v1 < v2)) {
    float t;
    t = (float) (x2 - x1) / (float) (v1 - v2);
    if (floor(t) == t) {
      return "YES";
    }
  }

  return "NO";
}

int main() {
  int x1;
  int v1;
  int x2;
  int v2;
  cin >> x1 >> v1 >> x2 >> v2;
  string result = kangaroo(x1, v1, x2, v2);
  cout << result << endl;
  return 0;
}
