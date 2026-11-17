class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current=root;
        while(current!=null){
            if(p.val<current.val && q.val<current.val){
                current=current.left;
            }
            else if(q.val>current.val && p.val>current.val){
                current=current.right;
            }
            else{
                return current;
            }
        }
        return null;
    }
}