class Solution {
    // Method to construct the lower array
    public int[] constructLowerArray(int[] arr) {
        int n = arr.length;
        seg = new int[4 * n];
        int[] ans = new int[n];
        List<int[]> temp = new ArrayList<>();

        // Create a list of pairs (value, index)
        for (int i = 0; i < n; i++) {
            temp.add(new int[]{arr[i], i});
        }
        
        // Sort the list based on values
        Collections.sort(temp, (a, b) -> Integer.compare(a[0], b[0]));

        // Process each element
        for (int i = 0; i < n; i++) {
            int index = temp.get(i)[1];
            ans[index] = query(0, index, 0, n - 1);
            update(0, index, 0, n - 1);
        }
        return ans;
    }

    private int[] seg;

    // Update the segment tree
    private void update(int i, int j, int l, int h) {
        if (j < l || j > h)
            return;
        seg[i]++;
        if (l == h)
            return;
        int mid = (l + h) >> 1;
        update(2 * i + 1, j, l, mid);
        update(2 * i + 2, j, mid + 1, h);
    }

    // Query the segment tree
    private int query(int i, int j, int l, int h) {
        if (h < j)
            return 0;
        if (l >= j)
            return seg[i];
        int mid = (l + h) >> 1;
        return query(2 * i + 1, j, l, mid) + query(2 * i + 2, j, mid + 1, h);
    }
};
