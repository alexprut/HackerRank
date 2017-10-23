#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int array_sum(vector<int>& numbers, int numbers_length) {
    int sum = 0;
    for (int arr_i = 0;arr_i < numbers_length;arr_i++) {
        sum += numbers[arr_i];
    }

    return sum;
}

int main(){
    int n;
    cin >> n;
    vector<int> arr(n);
    for(int arr_i = 0;arr_i < n;arr_i++){
       cin >> arr[arr_i];
    }

    cout << array_sum(arr, n);

    return 0;
}
