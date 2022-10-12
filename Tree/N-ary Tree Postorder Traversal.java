class Solution {
    public List<Integer> postorder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        postorderTraversal(root,ans);
        return ans;
    }
    
    private void postorderTraversal(Node root,List<Integer> ans){
        if(root==null)
            return ;
        
               
        List<Node> childrens =root.children;
        
        for(Node currchild: childrens){
            postorderTraversal(currchild,ans);
              
        }
        
        ans.add(root.val); 
        
        return;
    }
}
Footer
