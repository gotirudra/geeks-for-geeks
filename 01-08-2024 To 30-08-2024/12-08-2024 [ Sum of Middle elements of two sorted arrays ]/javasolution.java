class Solution {
    public int SumofMiddleElements(int[] arr1, int[] arr2) {
        int n = arr1.length;
      
        if (arr1.length > arr2.length) {
            return SumofMiddleElements(arr2, arr1);
        }
        
        int low = 0, high = n;
        
        while (low <= high) {
            int partition1 = (low + high) / 2;
            int partition2 = n - partition1;
         
            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : arr1[partition1 - 1];
            int minRight1 = (partition1 == n) ? Integer.MAX_VALUE : arr1[partition1];
        
            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : arr2[partition2 - 1];
            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : arr2[partition2];
         
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
               
                return Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2);
            } else if (maxLeft1 > minRight2) {
               
                high = partition1 - 1;
            } else {
                
                low = partition1 + 1;
            }
        }
      
        throw new IllegalArgumentException("Input arrays are not sorted or have different sizes.");
    }
}
