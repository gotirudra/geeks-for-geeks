class Solution {
    public int maxMeetings(int n, int[] start, int[] end) {
        int[][] timings = new int[n][2];
        for (int i = 0; i < n; i++) {
            timings[i][0] = end[i];  
            timings[i][1] = start[i]; 
        }
        
        Arrays.sort(timings, Comparator.comparingInt(a -> a[0]));
        
        int ans = 0;
        int lastMeetingEndTime = -1;
        
        for (int i = 0; i < n; i++) {
            int startTime = timings[i][1];
            int endTime = timings[i][0];
            
            if (startTime > lastMeetingEndTime) {
                lastMeetingEndTime = endTime;
                ans++;
            }
        }
        return ans;
    }
}
