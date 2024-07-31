class Solution {
    public String longestCommonPrefix(String arr[]) {
        if (arr == null || arr.length == 0) {
            return "-1";
        }
        
        // Sort the array
        Arrays.sort(arr);
        
        // Take the first and last string in the sorted array
        String first = arr[0];
        String last = arr[arr.length - 1];
        
        int i = 0;
        
        // Compare characters of the first and last string
        while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)) {
            i++;
        }
        
        // The common prefix length is 'i'
        String commonPrefix = first.substring(0, i);
        
        // If there's no common prefix
        if (commonPrefix.isEmpty()) {
            return "-1";
        }
        
        return commonPrefix;
    }
}
