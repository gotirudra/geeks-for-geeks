class Solution {
    public String removeDups(String str) {
        int length = str.length();
        StringBuilder ans = new StringBuilder();
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < length; i++) {
            char currentChar = str.charAt(i);
            if (!map.containsKey(currentChar)) {
                ans.append(currentChar);
                map.put(currentChar, 1);
            }
        }
        return ans.toString();
    }
}
