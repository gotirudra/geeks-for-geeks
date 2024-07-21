public class Solution {
    // Method to find the length of the longest alternating subsequence
    public int alternatingMaxLength(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        
        int n = 1, m = 1;  // Initialize lengths for up and down
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i]) {
                n = m + 1;
            } else if (arr[i] < arr[i - 1]) {
                m = n + 1;
            }
        }
        return Math.max(n, m);
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] arr1 = {1, 5, 4};
        System.out.println("Output: " + sol.alternatingMaxLength(arr1)); // Expected: 3
        
    }
}
