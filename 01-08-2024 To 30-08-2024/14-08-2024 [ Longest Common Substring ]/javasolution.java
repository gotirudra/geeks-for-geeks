class Solution {
    public int longestCommonSubstr(String str1, String str2) {
        int maxLen = 0;

        for (int i = 0; i < str1.length(); i++) {
            String str = "";
            for (int j = i; j < str1.length(); j++) {
                str += str1.charAt(j); 
                if (str2.indexOf(str) != -1) { 
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }
}
