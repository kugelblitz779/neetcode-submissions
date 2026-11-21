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
    int idx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(inorder[i], i);
        }

        return buildTree(0, n-1, preorder, map);
    }

    public TreeNode buildTree(int l, int r, int[] preorder, Map<Integer, Integer> map){
        if(l > r) return null;

        int root_val = preorder[idx++];
        TreeNode root = new TreeNode(root_val);

        int pos = map.get(root_val);
        root.left = buildTree(l, pos-1, preorder, map);
        root.right = buildTree(pos+1, r, preorder, map);
        return root;
    }
}
