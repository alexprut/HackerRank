#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main(){
    int n;
    cin >> n;
    vector<int> arr(n);
    for(int arr_i = 0;arr_i < n;arr_i++){
       cin >> arr[arr_i];
    }

    double sum_p = 0, sum_n =0, sum_z =0;
    for(int arr_i = 0;arr_i < n;arr_i++){
       if (arr[arr_i] < 0) {
           sum_n++;
       } else if (arr[arr_i] > 0) {
           sum_p++;
       } else {
           sum_z++;
       }
    }

    cout << (sum_p / n) << "\n" << (sum_n / n) << "\n" << (sum_z / n) ;

    return 0;
}
