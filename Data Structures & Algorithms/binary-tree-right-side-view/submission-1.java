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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root); 
        
        while(!q.isEmpty()){
            int len = q.size();
            int count = 0;
            while(count < len){
                TreeNode curr = q.poll();

                if(count == len-1)
                    list.add(curr.val);

                if(curr.left != null)
                    q.offer(curr.left);
                
                if(curr.right != null)
                    q.offer(curr.right);

                count++;
            }
        }

        return list;
    }
}










