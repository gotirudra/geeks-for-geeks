
class Solution {
    public List<Integer> find3Numbers(int[] arr) {
        int n = arr.length;
        if (n < 3) return new ArrayList<>();

        int[] smallest = new int[n];
        int[] largest = new int[n];

        smallest[0] = -1;
        int min = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] <= arr[min]) {
                min = i;
                smallest[i] = -1;
            } else {
                smallest[i] = min;
            }
        }

        largest[n - 1] = -1;
        int max = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= arr[max]) {
                max = i;
                largest[i] = -1;
            } else {
                largest[i] = max;
            }
        }

        for (int i = 0; i < n; i++) {
            if (smallest[i] != -1 && largest[i] != -1) {
                List<Integer> ans = new ArrayList<>();
                ans.add(arr[smallest[i]]);
                ans.add(arr[i]);
                ans.add(arr[largest[i]]);
                return ans;
            }
        }

        return new ArrayList<>();
    }

}
