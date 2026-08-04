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
    public int maxDepth(TreeNode root) {
        int depth = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        if(root != null) queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int current = 0 ; current < size ; current++){
                TreeNode actualNode = queue.poll();
                if(actualNode.left != null) queue.offer(actualNode.left);
                if(actualNode.right != null) queue.offer(actualNode.right);
            }
            depth++;
        }
        return depth;
    }
}
