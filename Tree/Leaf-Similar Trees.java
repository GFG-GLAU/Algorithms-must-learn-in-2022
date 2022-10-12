class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1= new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        
        findleaves(root1,l1);
        findleaves(root2,l2);
        
        return l1.equals(l2);
    }
    
    private void findleaves(TreeNode root,List<Integer> leaves){

        if(root==null)
            return ;
        
        if(root.left == null && root.right == null){
            leaves.add(root.val);
        }
        
        findleaves(root.left,leaves);
        findleaves(root.right,leaves);
        
        return ;
    }
    
}
