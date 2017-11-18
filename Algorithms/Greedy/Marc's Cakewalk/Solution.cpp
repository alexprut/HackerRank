#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    vector<int> calories;
    int n;
    long long int counter = 0;
    cin >> n;
    for (int i = 0; i < n; i++) {
        int tmp;
        cin >> tmp;
        calories.push_back(tmp);
    }

    sort(calories.begin(), calories.end(), greater<int>());

    for (int i = 0; i < n; i++) {
        counter += pow(2, i) * calories[i];
    }

    cout << counter;

    return 0;
}
