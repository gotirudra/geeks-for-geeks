
class Solution {
    private static final int MOD = 1000000007;

    public int Maximize(int[] arr) {
        Arrays.sort(arr);
        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += (long) arr[i] * i;
        }

        long ans = sum % MOD;
        return (int) ans;
    }
}
