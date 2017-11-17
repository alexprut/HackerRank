#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    int n;
    cin >> n;
    int maximum;
    int minimum;
    int minCounter = 0;
    int maxCounter = 0;
    cin >> maximum;
    minimum = maximum;

    for (int i = 1; i < n; i++) {
        int tmp;
        cin >> tmp;
        if (tmp > maximum) {
            maximum = tmp;
            maxCounter++;
        }

        if (tmp < minimum) {
            minimum = tmp;
            minCounter++;
        }
    }

    cout << maxCounter << " " << minCounter;

    return 0;
}
