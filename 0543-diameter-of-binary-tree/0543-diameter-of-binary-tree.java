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
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height_cal(root);
        return maxDiameter;
    }

    public int height_cal(TreeNode root){
        if(root==null){
            return 0;
        }

        int left=height_cal(root.left);
        int right=height_cal(root.right);
        maxDiameter=Math.max(left+right,maxDiameter);
        return 1+Math.max(left,right);
    }

}
