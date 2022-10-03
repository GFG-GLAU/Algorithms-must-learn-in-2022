#include<bits/stdc++.h>
using namespace std;
void swap( int *a , int *b)
{  int temp;
   temp=*a;
   *a=(*b);
   *b=temp;
}
int partition(int ar[],int start,int end)
{  int i=start-1,j=start,pivot;
   pivot=ar[end];
   while(j<end)
   {  if(ar[j]<pivot)
      { i++;
        swap(&ar[i],&ar[j]);
      }
      j++;
   }
   swap(&ar[i+1],&ar[end]);
   return (i+1);
}
void QuickSort(int ar[],int start,int end)
{  if(start<end)
   {  int q=partition(ar,start,end);
      QuickSort(ar,start,q-1);
      QuickSort(ar,q+1,end);
   }
}
int main()
{ int ar[]={10,60,12,56,54,25,41};
  int size=sizeof(ar)/sizeof(int); 
  QuickSort(ar,0,size-1);
  for(auto it:ar)
     cout<<it<<" ";
  return 0;
}
