class Solution {
    public int kthSmallest(int[] arr, int l, int r, int k) {
        return quickSelect(arr, l, r, k - 1); 
    }
    
    private int quickSelect(int[] arr, int l, int r, int k) {
        if (l == r) {
            return arr[l];
        }

        int pivotIndex = partition(arr, l, r);
        
        if (k == pivotIndex) {
            return arr[k];
        } else if (k < pivotIndex) {
            return quickSelect(arr, l, pivotIndex - 1, k);
        } else {
            return quickSelect(arr, pivotIndex + 1, r, k);
        }
    }
    
    private int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l;

        for (int j = l; j < r; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, r);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
