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


int main(){
    int n;
    cin >> n;
    if (n > 9) {
        cout << "Greater than 9";
    } else {
        if (n == 1) {
            cout << "one";
        }
        if (n == 2) {
            cout << "two";
        }
        if (n == 3) {
            cout << "three";
        }
        if (n == 4) {
            cout << "four";
        }
        if (n == 5) {
            cout << "five";
        }
        if (n == 6) {
            cout << "six";
        }
        if (n == 7) {
            cout << "seven";
        }
        if (n == 8) {
            cout << "eight";
        }
        if (n == 9) {
            cout << "nine";
        }
    }
    return 0;
}
