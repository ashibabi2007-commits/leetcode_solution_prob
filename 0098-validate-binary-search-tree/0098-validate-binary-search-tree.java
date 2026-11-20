class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root,null,null);
    }
    public boolean validate(TreeNode root,Integer min,Integer max){
        if(root==null){
            return true;
        }
        if((min!=null && root.val<=min)  || (max!=null && root.val>=max)  ){
            return false;
        }
        return validate(root.left,min,root.val) && validate(root.right,root.val,max);
    }
}