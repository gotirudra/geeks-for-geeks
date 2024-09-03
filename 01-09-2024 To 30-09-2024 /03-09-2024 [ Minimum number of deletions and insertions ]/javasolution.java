
class Solution {

    public int solve(int i, int j, String s1, String s2, int[][] dp) {
        if (i >= s1.length()) {
            return s2.length() - j;
        }
        if (j >= s2.length()) {
            return s1.length() - i;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = solve(i + 1, j + 1, s1, s2, dp);
        }

        int del = 1 + solve(i + 1, j, s1, s2, dp);
   
        int ins = 1 + solve(i, j + 1, s1, s2, dp);

        return dp[i][j] = Math.min(del, ins);
    }

    public int minOperations(String str1, String str2) {
        int[][] dp = new int[str1.length()][str2.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(0, 0, str1, str2, dp);
    }
}
