class Solution {
    public long floorSqrt(long n) {
        long s = 0, e = n;
        long ans = 0;
        while (s <= e) {
            long mid = s + (e - s) / 2;
            if (mid * mid == n) {
                return mid;
            } else if (mid * mid < n) {
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return ans;
    }
}
