#include<iostream>
using namespace std;

int binarySearch(int a[], int n, int k){
    int s = 0;
    int e = n;
    while(s <= e){
        int mid = (s+e)/2;
        if (a[mid] == k){
            return mid;
        }
        else if (a[mid] > k){
            e = mid - 1;
        }
        else {
            s = mid + 1;
        }
    }
    return -1;
}

int main(){

    int n;
    cin>>n;

    int a[n];
    for(int i = 0; i < n; i++){
        cin>>a[i];
    }

    int k;
    cin>>k;

    cout<<binarySearch(a,n,k)<<endl;
    return 0;
}
