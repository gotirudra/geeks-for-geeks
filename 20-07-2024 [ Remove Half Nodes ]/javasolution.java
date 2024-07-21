class Solution {
    Node RemoveHalfNodes(Node root) {
        if (root == null) return null;
        
        root.left = RemoveHalfNodes(root.left);
        root.right = RemoveHalfNodes(root.right);
        
        // If the current node is a half node with only one child
        if (root.left == null && root.right != null) {
            return root.right;
        } else if (root.right == null && root.left != null) {
            return root.left;
        }
        
        // If the current node is not a half node
        return root;
    }
}
