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


int main(){
    long int a;
    long int b;
    long int c;
    long int d;
    long int e;
    cin >> a >> b >> c >> d >> e;

    long int arr[5] = {a, b, c, d, e};

    sort(arr, arr + 5);

    cout << (arr[0] + arr[1] + arr[2] + arr[3]) << " " << (arr[4] + arr[1] + arr[2] + arr[3]);

    return 0;
}
