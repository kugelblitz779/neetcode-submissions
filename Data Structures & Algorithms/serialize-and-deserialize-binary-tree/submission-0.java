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

public class Codec {

    StringBuilder encoded=new StringBuilder("");
    int idx=0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfs(root);
        System.out.println(encoded.toString());
        return encoded.toString();
    }

    public void dfs(TreeNode root){
        if(root==null) {
            encoded.append("N");
            encoded.append(",");
            return;
        }

        encoded.append(root.val);
        encoded.append(",");

        dfs(root.left);
        dfs(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        idx=0;
        return build(nodes);
    }

    public TreeNode build(String[] nodes){
        if(nodes[idx].equals("N")){
            idx++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(nodes[idx]));
        idx++;

        root.left = build(nodes);
        root.right = build(nodes);
        return root;
    }
}







