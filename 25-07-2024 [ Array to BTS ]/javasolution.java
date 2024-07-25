public class Solution {
    // Method to convert a sorted array to a height-balanced BST
    public Node sortedArrayToBST(int[] nums) {
        return newBST(nums, 0, nums.length - 1);
    }
    
    // Helper method to recursively build the BST
    private Node newBST(int[] nums, int s, int e) {
        if (s > e) {
            return null;
        }
        int mid = s + (e - s) / 2;
        Node root = new Node(nums[mid]);
        root.left = newBST(nums, s, mid - 1);
        root.right = newBST(nums, mid + 1, e);
        return root;
    }
    
    // Definition of the Node class
    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums1 = {1, 2, 3, 4};
        Solution.Node root1 = obj.sortedArrayToBST(nums1); // Use Solution.Node here
        printPreOrder(root1);  // Output the tree to verify correctness

        int[] nums2 = {1, 2, 3, 4, 5, 6, 7};
        Solution.Node root2 = obj.sortedArrayToBST(nums2); // Use Solution.Node here
        printPreOrder(root2);  // Output the tree to verify correctness
    }

    // Method to print the preorder traversal of the BST
    private static void printPreOrder(Solution.Node root) { // Use Solution.Node here
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }
}
