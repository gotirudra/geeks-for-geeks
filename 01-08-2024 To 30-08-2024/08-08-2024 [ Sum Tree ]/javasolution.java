class Solution {
    
    private int sumTreeHelper(Node root) {
       
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.data;
      
        int leftSum = sumTreeHelper(root.left);
        int rightSum = sumTreeHelper(root.right);

        if (leftSum == Integer.MIN_VALUE || rightSum == Integer.MIN_VALUE || root.data != leftSum + rightSum) {
            return Integer.MIN_VALUE;
        }

        return root.data + leftSum + rightSum;
    }

    public boolean isSumTree(Node root) {
        return sumTreeHelper(root) != Integer.MIN_VALUE;
    }
}
