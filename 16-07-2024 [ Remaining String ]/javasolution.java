/*    "copy & past only code between lines (//----------//) for getting result"  */
/*    "use online java compiler for getting output of whole code"      */

//--------------------------------  start  ------------------------------

public class Solution {

    public String printString(String s, char ch, int count) {
        StringBuilder ans = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            if (count <= 0) {
                ans.append(s.charAt(i));
            }
            if (s.charAt(i) == ch) count--;
        }
        
        return ans.toString();
    } 
}; // don't write this line while executing whole code

//----------------------------  end  ----------------------------------------
  
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example input
        String s = "abacabad";
        char ch = 'a';
        int count = 2;
        
        // Print the modified string
        String result = sol.printString(s, ch, count);
        System.out.println("Resulting string: " + result);
    }
}
