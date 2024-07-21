class Solution {
    public long findMaxProduct(List<Integer> arr) {
        final int MOD = 1000000007;

        if (arr.size() == 1) {
            return arr.get(0) % MOD;
        }

        long maxNeg = Long.MIN_VALUE;
        int countNeg = 0, countZero = 0;
        long product = 1;

        for (int num : arr) {
            if (num == 0) {
                countZero++;
                continue;
            }
            if (num < 0) {
                countNeg++;
                maxNeg = Math.max(maxNeg, num);
            }
            product = (product * num) % MOD;
        }

        if (countZero == arr.size()) {
            return 0;
        }

        if (countNeg % 2 != 0) {
            if (countNeg == 1 && countZero > 0 && countZero + countNeg == arr.size()) {
                return 0;
            }
            product = product / maxNeg;
        }

        return (product + MOD) % MOD; // To handle negative products
    }
}
