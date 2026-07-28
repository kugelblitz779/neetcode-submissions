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
    int cnt;
    int smallest;
    public int kthSmallest(TreeNode root, int k) {
        cnt = k;
        dfs(root);

        return smallest;
    }


    public void dfs(TreeNode root){
        if(root == null || cnt == 0) return;

        dfs(root.left);

        if(cnt > 0) {
            cnt--;
            smallest = root.val;
        }

        dfs(root.right);
    }
}
