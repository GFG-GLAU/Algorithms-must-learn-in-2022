class Node  
{ 
    int data; 
    Node left, right; 
    public Node(int x) 
    { 
        this.data = x; 
        this.left=null;
        this.right=null;      
    } 
} 
public class MirrorTrees  
{ 
    Node firstTree, secondTree;
    boolean areMirror(Node firstTree, Node secondTree)  
    { 
        if (firstTree == null && secondTree == null) 
            return true; 
        if (firstTree == null || secondTree == null)  
            return false; 
        return firstTree.data == secondTree.data && areMirror(firstTree.left, secondTree.right) && areMirror(firstTree.right, secondTree.left); 
    } 
 public static void main(String[] args)  
    {
        MirrorTrees mt = new MirrorTrees(); 
        Node firstTree = new Node(1); 
        Node secondTree = new Node(1); 
        firstTree.left = new Node(2); 
        firstTree.right = new Node(3); 
        firstTree.left.left = new Node(4); 
        firstTree.left.right = new Node(5); 
        secondTree.left = new Node(3); 
        secondTree.right = new Node(2); 
        secondTree.right.left = new Node(5); 
        secondTree.right.right = new Node(4); 
        if (mt.areMirror(firstTree, secondTree)){ 
            System.out.println("They are mirror trees"); 
        }
        else{
            System.out.println("They are not mirror trees"); 
        }
  
    } 
}
