#include <bits/stdc++.h>
using namespace std;
bool compare(int a, int b){
	int x = pow(a, 3);
	int y = pow(b, 3);
	return x < y;
}
void CubicSort(int arr[], int n){
	sort(arr, arr + n, compare);
}

int main(){
	int arr[] = { 4, -1, 0, -5, 6 };
	int n = sizeof(arr) / sizeof(arr[0]);
	CubicSort(arr, n);
    for(int i=0;i<n;i++){
        cout<<arr[i]<<" ";
    }
	return 0;
}
