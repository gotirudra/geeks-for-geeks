class Solution {
    public String printString(String s, char ch, int count) {
        // Your code goes here
        StringBuilder ans = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            if (count <= 0) {
                ans.append(s.charAt(i));
            }
            if (s.charAt(i) == ch) count--;
        }
        return ans.toString();
    }
}

