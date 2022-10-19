class Node {

    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}
public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(Node root) {
        int diameter[] = new int[1];
        diameterOfTree(root, diameter);
        return diameter[0];        
    }

    private int diameterOfTree(Node node, int diameter[]) {
        if (node == null) return 0;
        
        int leftHeight = diameterOfTree(node.left, diameter);
        int rightHeight = diameterOfTree(node.right, diameter);
        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
