
#include<bits/stdc++.h>
using namespace std;

struct node{
    int data;
    node *right,*left;
};

struct node* newnode(int key)
{   
    struct node* temp=new(node);
    temp->data=key;
    temp->right=NULL;
    temp->left=NULL;
    return temp;
}

int maxpathsum(struct node* temp,int &maxi)
{   
    if(temp==NULL) 
        return 0;
    int leftmax=max(0,maxpathsum(temp->left,maxi));
    int rightmax=max(0,maxpathsum(temp->right,maxi));
    maxi=max(maxi,temp->data+leftmax+rightmax); 
    return temp->data + max(leftmax,rightmax);
}

int main()
{  
    struct node* root=newnode(10);
   int maxi=0;
   root->left=newnode(20);
   root->right=newnode(30);
   root->left->left=newnode(40);
   root->left->right=newnode(50);
   root->right->left=newnode(60);
   root->right->right=newnode(70);
   maxpathsum(root,maxi);
   cout<<"maximum path sum = "<<maxi;
   return 0;
}
