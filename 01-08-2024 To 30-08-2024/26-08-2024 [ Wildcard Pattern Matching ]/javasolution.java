
class Solution {
    public int wildCard(String pattern, String str) {
        int m = pattern.length();
        int n = str.length();
       
        boolean[][] dp = new boolean[m + 1][n + 1];
       
        dp[0][0] = true;
      
        for (int i = 1; i <= m; i++) {
            if (pattern.charAt(i - 1) == '*') {
                dp[i][0] = dp[i - 1][0];
            }
        }
      
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char pChar = pattern.charAt(i - 1);
                char sChar = str.charAt(j - 1);
                
                if (pChar == sChar || pChar == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pChar == '*') {
                    // * matches zero or more characters
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
      
        return dp[m][n] ? 1 : 0;
    }

}

