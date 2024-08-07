class Solution {
    public int kthElement(int k, int[] arr1, int[] arr2) {
        int s = arr1.length - 1;
        int e = 0;
        int n = arr2.length;
        int n1 = arr1.length;
        if (k > n1 + n) return -1;
        while (s >= 0 && e < n) {
            if (arr1[s] > arr2[e]) {
                // Swap elements
                int temp = arr1[s];
                arr1[s] = arr2[e];
                arr2[e] = temp;
                s--;
                e++;
            } else {
                break;
            }
        }
        // Sort arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if (k <= n1) {
            return arr1[k - 1];
        }
        k = k - n1;
        return arr2[k - 1];
    }
}
