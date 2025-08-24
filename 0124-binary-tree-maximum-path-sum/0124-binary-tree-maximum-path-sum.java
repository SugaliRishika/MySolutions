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
    public int maxPathSum(TreeNode root) {
        int[] max_Value=new int[1];
        max_Value[0]=Integer.MIN_VALUE;
        maxPath(root,max_Value);
        return max_Value[0];
    }

    private int maxPath(TreeNode node,int max_Value[]){
        if(node==null) return 0;
        int left=Math.max(0,maxPath(node.left,max_Value));
        int right=Math.max(0,maxPath(node.right,max_Value));
        max_Value[0]=Math.max(max_Value[0],left+right+node.val);
        return Math.max(left,right)+node.val;
    }
}