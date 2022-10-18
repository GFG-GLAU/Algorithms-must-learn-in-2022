#include <bits/stdc++.h>
using namespace std;
 
// Function to print nth permutation
// using next_permute()
void nPermute(string str, long int n)
{
    // Sort the string in lexicographically
    // ascending order
    sort(str.begin(), str.end());
 
    // Keep iterating until
    // we reach nth position
    long int i = 1;
    do {
        // check for nth iteration
        if (i == n)
            break;
 
        i++;
    } while (next_permutation(str.begin(), str.end()));
 
    // print string after nth iteration
    cout << str;
}
 
// Driver code
int main()
{
    string str = "GEEKSFORGEEKS";
    long int n = 100;
    nPermute(str, n);
    return 0;
}
