import java.util.*;

class Solution {
    public int kthSmallest(int[] arr, int k) {
       
        int maxi = Arrays.stream(arr).max().getAsInt();
     
        int[] freq = new int[maxi + 1];
       
        for (int num : arr) {
            freq[num]++;
        }
    
        for (int i = 0; i <= maxi; i++) {
            if (freq[i] != 0) {
                k -= freq[i];
                if (k <= 0) {
                    return i;
                }
            }
        }
  
        return -1;
    }
}
