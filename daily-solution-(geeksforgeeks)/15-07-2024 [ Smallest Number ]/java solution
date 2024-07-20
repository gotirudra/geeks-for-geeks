
class Solution {
    public String smallestNumber(int s, int d) {
        // If the sum s is greater than the maximum possible sum with d digits, return "-1"
        if (s > 9 * d) {
            return "-1";
        }

        // Initialize the result as an empty string
        String ans = "";

        // Traverse the digits from the most significant to the least significant
        for (int i = d; i >= 1; i--) {
            // Find the maximum digit we can use for the current place
            for (int j = 9; j >= 0; j--) {
                // Check if the remaining sum after using j is valid
                if (i != 1) {
                    if (s - j > 0) {
                        ans = j + ans;  // Append the digit to the result
                        s -= j;         // Decrease the sum by the chosen digit
                        break;
                    }
                } else {
                    ans = s + ans;  // For the least significant digit, use the remaining sum
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.smallestNumber(9, 2));  // Output: "18"
        System.out.println(sol.smallestNumber(20, 3)); // Output: "299"
        System.out.println(sol.smallestNumber(21, 2)); // Output: "-1"
    }
}
