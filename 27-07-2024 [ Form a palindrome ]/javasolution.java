class Solution {
    private int[][] dp;

    private int fun(String str, int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        if (str.charAt(i) == str.charAt(j)) {
            ans = fun(str, i + 1, j - 1);
        } else {
            ans = Math.min(fun(str, i + 1, j) + 1, fun(str, i, j - 1) + 1);
        }
        dp[i][j] = ans;
        return ans;
    }

    public int countMin(String str) {
        int n = str.length();
        dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return fun(str, 0, n - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "your_string_here";
        System.out.println(solution.countMin(str));
    }
}
