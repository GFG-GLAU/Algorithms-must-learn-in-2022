package questions.Trees.BinaryTree.DFS;

import java.util.Scanner;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        data = x;
        left = right = null;
    }
}
public class dfs {
    TreeNode root;
    void insert(int key) {
        root = insertRec(root, key);
    }
    TreeNode insertRec(TreeNode root, int data)
    {
        Scanner sc = new Scanner(System.in);
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }
        System.out.println("Enter choice : \n 1. Left \n 2. Right");
        int x = sc.nextInt();
        if (x==1)
            root.left = insertRec(root.left, data);
        else if (x==2)
            root.right = insertRec(root.right, data);
        return root;
    }
    public static void preOrder(TreeNode node)
    {
        if(node == null) return;

        System.out.print(node.data+" ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void inOrder(TreeNode node)
    {
        if(node == null) return;

        inOrder(node.left);
        System.out.print(node.data+" ");
        inOrder(node.right);
    }
    public static void postOrder(TreeNode node)
    {
        if(node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data+" ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        dfs obj = new dfs();
        while(true){
            System.out.print("Enter Value : ");
            int x = sc.nextInt();
            if(x <0) break;
            obj.insert(x);
        }
        System.out.print("\nPreOrder -> ");
        preOrder(obj.root);
        System.out.print("\nInOrder -> ");
        inOrder(obj.root);
        System.out.print("\nPostOrder -> ");
        postOrder(obj.root);
    }
}
