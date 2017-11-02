#include <iostream>
#include <deque>
using namespace std;
void printKMax(int arr[], int n, int k){
    std::deque<int>  Qi;
    int i;
    for (i = 0; i < k; ++i) {
        while ( (!Qi.empty()) && arr[i] >= arr[Qi.back()])
            Qi.pop_back();

        Qi.push_back(i);
    }

    for ( ; i < n; ++i) {
        cout << arr[Qi.front()] << " ";

        while ( (!Qi.empty()) && Qi.front() <= i - k)
            Qi.pop_front();

        while ( (!Qi.empty()) && arr[i] >= arr[Qi.back()])
            Qi.pop_back();

        Qi.push_back(i);
    }

    cout << arr[Qi.front()] << "\n";
}
int main(){

   int t;
   cin >> t;
   while(t>0) {
      int n,k;
       cin >> n >> k;
       int i;
       int arr[n];
       for(i=0;i<n;i++)
            cin >> arr[i];
       printKMax(arr, n, k);
       t--;
     }
     return 0;
}
