#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

void printArray(int numbers[], int n) {
    for (int i = 0; i < n; i++) {
        cout << numbers[i];
        cout << " ";
    }
    cout << "\n";
}

int main() {
    int n;
    cin >> n;
    int arr[n];
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    int tmp = arr[n-1];
    int i = n-2;
    while (i >= 0 && arr[i] > tmp) {
        arr[i+1] = arr[i];
        printArray(arr, n);
        i--;
    }
    arr[i+1] = tmp;
    printArray(arr, n);

    return 0;
}
