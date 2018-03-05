#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
  int a, b;
  cin >> a >> b;
  cout << (a+a%2)*(b+b%2)/4;
  return 0;
}
