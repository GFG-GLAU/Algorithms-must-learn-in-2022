// Linear search
// Time complexity: O(n)
// Space complexity: O(1)
#include <bits/stdc++.h>
using namespace std;
int main() {
    int n, x;
    cin >> n >> x;
    vector<int> a(n);
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    int pos = -1;
    for (int i = 0; i < n; i++) {
        if (a[i] == x) {
            pos = i;
            break;
        }
    }
    cout << pos << endl;
    return 0;
}