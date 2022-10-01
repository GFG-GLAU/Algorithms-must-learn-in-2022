package questions.Trees.BinaryTree.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfs {
    static Scanner sc = new Scanner(System.in);

    class TreeNode {
        int data;
        TreeNode right, left;

        public TreeNode(int data) {
            this.data = data;
            left = right = null;
        }
    }

    TreeNode root;

    public void insert(int value) {
        root = insertRec(root, value);
    }

    public TreeNode insertRec(TreeNode root, int val) {
        if (val == -1) return root;
        root = new TreeNode(val);
        System.out.print("Enter value for Left of " + root.data + " : ");
        root.left = insertRec(root.left, sc.nextInt());
        System.out.print("Enter value for Right of " + root.data + " : ");
        root.right = insertRec(root.right, sc.nextInt());
        return root;
    }

    public void levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if(cur == null){
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                    System.out.println();
                    continue;
                }
            }
            System.out.print(cur.data+" ");
            if(cur.left != null) q.add(cur.left);
            if(cur.right != null) q.add(cur.right);
        }
    }
    public static void main(String[] args) {
        bfs obj = new bfs();
        System.out.print("Enter Root : ");
        obj.insert(sc.nextInt());
        System.out.println("Level Order -> ");
        obj.levelOrder(obj.root);
    }
}
