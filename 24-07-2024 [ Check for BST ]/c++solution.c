class Solution {
public:
    // Helper function to check if the tree is a BST
    bool isBSTUtil(Node* node, int min, int max) {
        // An empty tree is BST
        if (node == nullptr) {
            return true;
        }

        // False if this node violates the min/max constraint
        if (node->data <= min || node->data >= max) {
            return false;
        }

        // Otherwise check the subtrees recursively
        // tightening the min or max constraint
        return (isBSTUtil(node->left, min, node->data) &&
                isBSTUtil(node->right, node->data, max));
    }

    // Function to check whether a Binary Tree is BST or not
    bool isBST(Node* root) {
        // Initialize the min and max values
        return isBSTUtil(root, INT_MIN, INT_MAX);
    }
};
