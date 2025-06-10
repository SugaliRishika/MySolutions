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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> result=new ArrayList<>();
        inOrderTraversal(root,result);
        if(root==null) return -1;
        if(k<1 || k>result.size()) return -1;
        return result.get(k-1);
    }
    public void inOrderTraversal(TreeNode node,ArrayList<Integer>result){
        if(node==null) return;

        inOrderTraversal(node.left,result);
        result.add(node.val);
        inOrderTraversal(node.right,result);
    }
}