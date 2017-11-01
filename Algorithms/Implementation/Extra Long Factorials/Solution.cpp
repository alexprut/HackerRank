#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <sstream>
#include <iostream>

using namespace std;

vector<int> sum(vector<int> a, vector<int> b) {
    vector<int> result;
    int remainder = 0;
    int asize = (int)a.size();
    int bsize = (int)b.size();

    if (asize > bsize) {
        for (int i = 0; i < asize - bsize; i++) {
            b.insert(b.begin(), 0);
        }
    } else if (asize < bsize) {
        for (int i = 0; i < bsize - asize; i++) {
            a.insert(a.begin(), 0);
        }
    }
    for (int i = (int)(a.size() - 1); i >= 0; i--) {
        int sum = a[i] + b[i] + remainder;
        remainder = sum / 10;
        result.insert(result.begin(), sum % 10);
    }
    if (remainder > 0) {
        result.insert(result.begin(), remainder);
    }

    return result;
}

vector<int> multiply(vector<int> a, vector<int> b) {
    vector<int> result;

    for (long i = b.size() - 1; i >= 0; i--) {
        vector<int> tmp;
        int remainder = 0;

        for (int j = (int)(a.size() - 1); j >= 0; j--) {
            int product = (int)(a[j] * b[i] + remainder);
            tmp.insert(tmp.begin(), product % 10);
            remainder = product / 10;
        }

        if (remainder > 0) {
            tmp.insert(tmp.begin(), (int)remainder);
        }

        for (int z = 0; z < b.size() - i - 1; z++) {
            tmp.push_back(0);
        }

        result = sum(result, tmp);
    }

    return result;
}

vector<int> createVectorNumber(int n) {
    vector<int> result;
    int number;

    string stringNumber = to_string(n);
    std::stringstream iss( stringNumber );

    while ( iss >> number )
        result.push_back( number );

    return result;
}

vector<int> factorial(int n) {
    vector<int> result;

    if ((n - 1) > 0) {
        return multiply(createVectorNumber(n), factorial(n - 1));
    }

    result.push_back(1);

    return result;
}

int main() {
    int n;
    scanf("%d", &n);

    vector<int> result = factorial(n);

    for (int i = 0; i < result.size(); i++) {
        cout << result[i];
    }

    return 0;
}
