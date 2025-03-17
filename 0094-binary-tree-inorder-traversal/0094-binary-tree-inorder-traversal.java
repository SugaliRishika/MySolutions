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
// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         ArrayList<Integer> arr=new ArrayList<>();
//         inorder(root,arr);
//         return arr;
//     }
//     private void inorder(TreeNode root, ArrayList<Integer> arr){
//         if(root!=null){
//             inorder(root.left,arr);
//             arr.add(root.val);
//             inorder(root.right,arr);
//         }
//     }
// }

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ls=new ArrayList<Integer>();
        Stack<TreeNode> st=new Stack<TreeNode>();
        TreeNode node=root;
        while(true){
            if(node!=null){
                st.push(node);
                node=node.left;
            }
            else{
                if(st.isEmpty()){
                    break;
                }
                node = st.pop();
                ls.add(node.val);
                node=node.right;
            }
        }
        return ls;
    }
}