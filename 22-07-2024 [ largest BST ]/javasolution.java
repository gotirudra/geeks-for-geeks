class Solution {
    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root) {
        return largestBstHelper(root).size;
    }

    private static Info largestBstHelper(Node node) {
        // An empty tree is a BST of size 0
        if (node == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        // Recursively get info from left and right subtrees
        Info leftInfo = largestBstHelper(node.left);
        Info rightInfo = largestBstHelper(node.right);

        // Current node's data should be greater than max in left subtree and smaller than min in right subtree
        if (leftInfo.isBST && rightInfo.isBST && leftInfo.max < node.data && node.data < rightInfo.min) {
            int size = leftInfo.size + rightInfo.size + 1;
            int min = Math.min(leftInfo.min, node.data);
            int max = Math.max(rightInfo.max, node.data);
            return new Info(true, size, min, max);
        } else {
            return new Info(false, Math.max(leftInfo.size, rightInfo.size), 0, 0);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(4);
        root.right = new Node(4);
        root.left.left = new Node(6);
        root.left.right = new Node(8);

        System.out.println(largestBst(root));  // Output: 1
    }
}
