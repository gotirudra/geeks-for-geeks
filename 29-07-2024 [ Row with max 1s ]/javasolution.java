class Solution {
    public int rowWithMax1s(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        
        int ans = -1;
        int k = m;
        
        for (int i = 0; i < n; i++) {
            int j;
            for (j = k - 1; j >= 0; j--) {
                if (arr[i][j] == 0) {
                    if (k > (j + 1)) {
                        k = j + 1;
                        ans = i;
                    }
                    break;
                }
            }
            if (j < 0) {
                return i;
            }
        }
        
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] arr = {
            {0, 1, 1, 1},
            {0, 0, 1, 1},
            {1, 1, 1, 1},
            {0, 0, 0, 0}
        };
        System.out.println("Row with maximum 1s: " + sol.rowWithMax1s(arr));
    }
}
