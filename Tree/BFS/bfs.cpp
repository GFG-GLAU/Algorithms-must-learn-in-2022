// level order traversal using queue
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
void lvl(struct node* temp)
{  if(!temp)
     return;
   queue<node*> q;
   q.push(temp);
   while(!q.empty())
   {  struct node* ptr=q.front();
      q.pop();
      cout<<ptr->data<<" ";
      if(ptr->left!=NULL) q.push(ptr->left);
      if(ptr->right!=NULL) q.push(ptr->right);
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
   lvl(root);
   return 0;
}
