class Solution {
    
    int[] JobScheduling(Job arr[], int n) {
        
        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));
     
        int maxDeadline = 0;
        for (Job job : arr) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }
       
        boolean[] slots = new boolean[maxDeadline + 1];
        int totalProfit = 0, jobsCount = 0;
       
        for (Job job : arr) {
            
            for (int j = job.deadline; j > 0; j--) {
                if (!slots[j]) {
                    slots[j] = true;  
                    totalProfit += job.profit;
                    jobsCount++;
                    break;
                }
            }
        }
        
        return new int[]{jobsCount, totalProfit};
    }
};
