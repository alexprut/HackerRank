#include <iostream>
#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
#include <vector>
#include <jmorecfg.h>
#include <unordered_map>

using namespace std;

int countMatches(unordered_multimap<string, int> &strings, string query) {
  return (int)(strings.count(query));
}

int main() {
  int nrStrings;
  int nrQueries;
  unordered_multimap<string, int> strings;
  vector<int> results;

  cin >> nrStrings;

  for (int i = 0; i < nrStrings; ++i) {
    string tmpString;
    cin >> tmpString;
    strings.insert(make_pair(tmpString, 0));
  }

  cin >> nrQueries;

  for (int j = 0; j < nrQueries; ++j) {
    string tmpQuery;
    cin >> tmpQuery;
    results.push_back(countMatches(strings, tmpQuery));
  }

  for (int k = 0; k < results.size(); ++k) {
    cout << results[k] << "\n";
  }

  return 0;
}
