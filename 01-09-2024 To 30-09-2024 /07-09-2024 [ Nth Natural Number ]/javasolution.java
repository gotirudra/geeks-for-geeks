class Solution {
    public long findNth(long n) {
        long base = 1, result = 0;
        while (n > 0) {
            result += (n % 9) * base;
            base *= 10;
            n /= 9;
        }
        return result;
    }
}
