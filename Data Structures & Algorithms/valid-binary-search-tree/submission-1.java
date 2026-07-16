/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,-10001,10001);
    }

    boolean isValidBST(TreeNode root,int min,int max) {
        if(root == null)
        return true;

        if(root.val <= min || max <= root.val)
        return false;

        return isValidBST(root.left,min,root.val) && isValidBST(root.right,root.val,max);
    }
}
