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

bool isBalanced(string b) {
    stack<char> s;

    for (int i = 0; i < b.length(); i++) {
        if (b[i] == '[' || b[i] == '(' || b[i] == '{') {
            s.push(b[i]);
        } else {
            if (s.size() == 0) { return false; }
            if (s.top() == '(' && b[i] != ')') { return false; }
            if (s.top() == '[' && b[i] != ']') { return false; }
            if (s.top() == '{' && b[i] != '}') { return false; }
            s.pop();
        }
    }

    return (s.size() == 0) ? true : false;
}

int main(){
    int t;
    vector<string> result;
    cin >> t;
    for(int a0 = 0; a0 < t; a0++){
        string s;
        cin >> s;
        if (isBalanced(s)) {
            result.push_back("YES");
        } else {
            result.push_back("NO");
        }
    }

    for (int i = 0; i < result.size(); i++) {
        cout << result[i] << "\n";
    }

    return 0;
}
