#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    int n, q;
    vector<int> numbers;
    cin >> n;
    for (int i = 0; i < n; i++) {
        int tmp;
        cin >> tmp;
        numbers.push_back(tmp);
    }
    cin >> q;
    for (int i = 0; i < q; i++) {
        int s;
        cin >> s;
        auto low = lower_bound(numbers.begin(), numbers.end(), s);
        int index = (low - numbers.begin());
        if (s == numbers[index]) {
            cout << "Yes " << index + 1 << "\n";
        } else {
            cout << "No " << index + 1 << "\n";
        }
    }
    return 0;
}
