class Solution {
    public boolean canSplit(int[] arr) {
        long sum1 = 0;
        long sum2 = 0;

        for (int x : arr) {
            sum1 += x;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            sum2 += arr[i];
            sum1 -= arr[i]; 
           
            if (sum2 == sum1) {
                return true;
            }
        }

        return false;
    }
}
