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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> nodes = new ArrayList<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0));

        while (!queue.isEmpty()) {
            Tuple t = queue.poll();
            TreeNode node = t.node;
            int row = t.row, col = t.col;
            nodes.add(new int[]{col, row, node.val});

            if (node.left != null)
                queue.offer(new Tuple(node.left, row + 1, col - 1));
            if (node.right != null)
                queue.offer(new Tuple(node.right, row + 1, col + 1));
        }

        Collections.sort(nodes, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];    
            if (a[1] != b[1]) return a[1] - b[1];     
            return a[2] - b[2];                      
        });

        List<List<Integer>> result = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;
        List<Integer> colList = new ArrayList<>();

        for (int[] triplet : nodes) {
            int col = triplet[0], val = triplet[2];
            if (col != prevCol) {
                if (!colList.isEmpty()) result.add(colList);
                colList = new ArrayList<>();
                prevCol = col;
            }
            colList.add(val);
        }
        result.add(colList); 
        return result;
    }

    class Tuple {
        TreeNode node;
        int row, col;
        Tuple(TreeNode n, int r, int c) {
            node = n;
            row = r;
            col = c;
        }
    }
    
}