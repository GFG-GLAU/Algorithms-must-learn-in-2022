// to do the zigzag traversal of binary tree.
// flag=1 L->R , flag=0 R->L;
#include<bits/stdc++.h>
using namespace std;
struct node
{  int data;
   node *right, *left;
};
struct node* newnode(int key)
{  struct node* temp= new node;
   temp->data=key;
   temp->right=temp->left=NULL;
   return temp;
}
vector<vector<int>> solve(struct node *ptr)
{   vector<vector<int>>ans;
    queue<node*> q;
    bool flag=true;
    q.push(ptr);
    while(!q.empty()){
        vector<node*> vt;
        while(!q.empty()){
            vt.push_back(q.front());
            q.pop();
        }
        for(auto it:vt){
            if(it->left!=NULL) q.push(it->left);
            if(it->right!=NULL) q.push(it->right);
        }
        vector<int> temp;
        if(flag==true){
            for(auto it:vt)
               temp.push_back(it->data);
            flag=false;
            ans.push_back(temp);
        }
        else{
            for(auto it:vt)
               temp.push_back(it->data);
            flag=true;
            reverse(temp.begin(),temp.end());
            ans.push_back(temp);
        }
    }
    return ans;
}
void zigzag(struct node *root){
    vector<vector<int>> vt;
    vt=solve(root);
    for(auto it:vt){
        for(auto it1:it){
            cout<<it1<<" ";
        }
        cout<<"\n";
    }
}
int main()
{  struct node* root=newnode(10);
   root->left=newnode(20);
   root->right=newnode(30);
   root->left->left=newnode(40);
   root->left->right=newnode(50);
   root->right->left=newnode(60);
   root->right->right=newnode(70);
   zigzag(root);
   return 0;
}

