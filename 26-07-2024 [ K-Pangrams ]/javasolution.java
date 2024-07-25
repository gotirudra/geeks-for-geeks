class Solution {

    public boolean kPangram(String str, int k) {
        // Remove spaces and check if the length of the string is at least 26
        str = str.replaceAll(" ", "");
        if (str.length() < 26) return false;
        
        // Use a Set to track unique characters
        Set<Character> uniqueChars = new HashSet<>();
        
        for (char c : str.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                uniqueChars.add(c);
            }
        }
        
        // Calculate the number of missing characters to make a pangram
        int missingCount = 26 - uniqueChars.size();
        
        // Check if we can cover all missing characters with at most k swaps
        return missingCount <= k;
    }
    
    public void test() {
        // Define test cases
        String str1 = "the quick brown fox jumps over the lazy dog";
        int k1 = 0;
        System.out.println(kPangram(str1, k1)); // Expected Output: true
        
        String str2 = "aaaaaaaaaaaaaaaaaaaaaaaaaa";
        int k2 = 25;
        System.out.println(kPangram(str2, k2)); // Expected Output: true
        
        String str3 = "a b c d e f g h i j k l m";
        int k3 = 20;
        System.out.println(kPangram(str3, k3)); // Expected Output: false
        
        // Additional test cases
        String str4 = "a b c d e f g h i j k l m n o p";
        int k4 = 20;
        System.out.println(kPangram(str4, k4)); // Expected Output: false

        String str5 = "abcdefghijklmnopqrstuvwxyz";
        int k5 = 0;
        System.out.println(kPangram(str5, k5)); // Expected Output: true
    }
    
    public static void main(String[] args) {
        // Create an instance of the Solution class
        Solution sol = new Solution();
        
        // Run the test cases
        sol.test();
    }
}
