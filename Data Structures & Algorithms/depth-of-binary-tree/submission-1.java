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
    int depth = 0;
    public int maxDepth(TreeNode root) {
        dfs(root,0);
        return depth;
    }

    public void dfs(TreeNode node, int tempDepth){
        if(node == null){
            return;
        }
        tempDepth++;
        depth = Math.max(tempDepth, depth);
        dfs(node.left, tempDepth);
        dfs(node.right, tempDepth);

    }
}
