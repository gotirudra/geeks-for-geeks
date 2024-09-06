class Solution {
   
    public long maxSubarraySum(int[] arr) {
        long ans = Integer.MIN_VALUE;
        long curr = 0;
        
        for (int val : arr) {
            curr += val;
            ans = Math.max(curr, ans);
            if (curr < 0) {
                curr = 0;
            }
        }
        
        return ans;
    }
}
