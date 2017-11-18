#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    int n, k;
    cin >> n;
    cin >> k;
    vector<pair<int,int>> entries(n);
    for (int i = 0; i < n; i++) {
        int l, t;
        cin >> l;
        cin >> t;
        entries[i] = make_pair(l, t);
    }
    sort(entries.begin(), entries.end());

    int counterK = 0, counterLuck = 0;
    for (int i = n - 1; i >= 0; i--) {
        if (entries[i].second == 1) {
            if (counterK < k) {
                counterK++;
                counterLuck += entries[i].first;
            } else {
                counterLuck -= entries[i].first;
            }

        } else {
            counterLuck += entries[i].first;
        }
    }

    cout << counterLuck;

    return 0;
}
