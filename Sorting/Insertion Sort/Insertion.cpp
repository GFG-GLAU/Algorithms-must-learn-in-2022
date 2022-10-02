#include<bits/stdc++.h>
using namespace std;
int main()
{  int arr[1000]
   int size;
   cout<<"enter the size : ";
   cin>>size;
   cout<<"enter the Integers : ";
   for(int i=0 ; i<size ; i++)
      cin>>arr[i];
   int i=1;
   while(i<size)
   {  int ele=arr[i];
      for(int j=i-1 ; j>=0 ; j--)
      {  if(arr[j]>arr[j+1])
         {  arr[j+1]=arr[j]; 
            arr[j]=ele;
         }
      }
      i++;
   }
   for(int i=0 ; i<size ; i++)
      cout<<arr[i]<<" ";
    return 0 ;
}
