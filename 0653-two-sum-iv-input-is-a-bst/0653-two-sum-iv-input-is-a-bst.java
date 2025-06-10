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
import java.util.*;

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;

        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();

        pushLeft(leftStack, root);
        pushRight(rightStack, root);

        TreeNode left = nextEleLeft(leftStack);
        TreeNode right = nextEleRight(rightStack);

        while (left != null && right != null && left != right) {
            int sum = left.val + right.val;
            if (sum == k) return true;
            if (sum < k)
                left = nextEleLeft(leftStack);
            else
                right = nextEleRight(rightStack);
        }

        return false;
    }

    private void pushLeft(Stack<TreeNode> stack, TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    private void pushRight(Stack<TreeNode> stack, TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.right;
        }
    }

    private TreeNode nextEleLeft(Stack<TreeNode> stack) {
        if (stack.isEmpty()) return null;
        TreeNode node = stack.pop();
        pushLeft(stack, node.right);
        return node;
    }

    private TreeNode nextEleRight(Stack<TreeNode> stack) {
        if (stack.isEmpty()) return null;
        TreeNode node = stack.pop();
        pushRight(stack, node.left);
        return node;
    }
}
