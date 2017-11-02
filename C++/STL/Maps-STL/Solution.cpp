#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <map>
using namespace std;


int main() {
    int n;
    cin >> n;
    map<string,int> m;
    for (int i = 0; i < n; i++) {
        int type, mark;
        string name;
        cin >> type >> name;
        if (type == 1) {
            cin >> mark;
            auto it = m.find(name);
            if (it != m.end()) {
                m[name] += mark;
            } else {
              m[name] = mark;
            }
        } else if (type == 2) {
            m.erase(name);
        } else if (type == 3) {
            auto it = m.find(name);
            if (it != m.end()) {
                cout << m[name] << "\n";
            } else {
                cout << "0\n";
            }
        }
    }
    return 0;
}
