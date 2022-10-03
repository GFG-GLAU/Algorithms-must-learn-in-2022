#include <bits/stdc++.h>
using namespace std;
void subset(int index,vector<int> &vect,int ar[],int size)
{  if(index==size){
     for(auto it:vect)
        cout<<it<<" ";
     cout<<endl;
     return;
   }
   vect.push_back(ar[index]);
   subset( index+1,vect,ar,size);
   vect.pop_back();
   subset( index+1,vect,ar,size);
}
int main()
{   int ar[]={1,2,3,3},size; 
    vector<int> vect;
    size=sizeof(ar)/sizeof(int);
    subset(0,vect,ar,size);
    return 0;
}
