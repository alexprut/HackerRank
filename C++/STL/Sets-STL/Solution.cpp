#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <set>
#include <algorithm>
using namespace std;


int main() {
    int n;
    cin >> n;
    set<int> s;
    for (int i = 0; i < n; i++) {
        int type;
        int value;
        cin >> type >> value;
        if (type == 1) {
            s.insert(value);
        } else if (type == 2) {
            s.erase(value);
        } else if (type == 3) {
            auto it = s.find(value);
            if (it != s.end()) {
                cout << "Yes\n";
            } else {
                cout << "No\n";
            }
        }
    }
    return 0;
}
