#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main(){
    int n;
    cin >> n;
    vector< vector<int> > a(n,vector<int>(n));
    for(int a_i = 0;a_i < n;a_i++){
       for(int a_j = 0;a_j < n;a_j++){
          cin >> a[a_i][a_j];
       }
    }

    int sum_d1 = 0, sum_d2 = 0;
    for (int a_i = 0;a_i < n;a_i++) {
        sum_d1 += a[a_i][a_i];
        sum_d2 += a[a_i][n-a_i-1];
    }

    cout << abs(sum_d1 - sum_d2);

    return 0;
}
