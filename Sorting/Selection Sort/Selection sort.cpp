//Selection sort in C++
#include<iostream>
using namespace std;
int main()
{
    int n;
    cin>>n;
    int a[n];
    for(int i=0;i<n;i++)
    cin>>a[i];
    for(int i=0;i<n;i++)
    {
        int minpos=i;
        for(int j=i;j<n;j++)
        {
            if(a[j]<a[minpos])
            minpos=j;
        }
        swap(a[i],a[minpos]);
    }
    for(int i=0;i<n;i++)
    cout<<a[i]<<" ";
    return 0;
}
