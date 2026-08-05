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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    }

    public boolean dfs(TreeNode node, TreeNode subNode){
        if(node == null){
            return false;
        }
        if(node.val == subNode.val){
            if(isSame(node, subNode)){
                return true;
            }
        }
        if(dfs(node.left, subNode) || dfs(node.right, subNode)){
            return true;
        }
        return false;
    }

    public boolean isSame(TreeNode node, TreeNode subNode){
        if(node == null && subNode == null){
            return true;
        }
        if(node == null || subNode == null){
            return false;
        }
        if(node.val == subNode.val){
            return(isSame(node.left, subNode.left) && isSame(node.right,subNode.right));    
        }
        return false;
    }
}
