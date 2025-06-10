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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> mpp=new HashMap<Integer,Integer>();

        for(int i=0;i<inorder.length;i++){
            mpp.put(inorder[i],i);
        }

        TreeNode root= buildingTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,mpp);

        return root;
    }
    public TreeNode buildingTree(int[] preorder,int prestart, int preend,int[] inorder,int instart,int inend,Map<Integer,Integer> mpp){

        if(prestart>preend || instart>inend) return null;
        TreeNode root=new TreeNode(preorder[prestart]);

        int mp=mpp.get(root.val);
        int lens=mp-instart;

        root.left=buildingTree(preorder,prestart+1,prestart+lens,inorder,instart,mp-1,mpp);

        root.right=buildingTree(preorder,prestart+lens+1,preend,inorder,mp+1,inend,mpp);

        return root;
    }
}