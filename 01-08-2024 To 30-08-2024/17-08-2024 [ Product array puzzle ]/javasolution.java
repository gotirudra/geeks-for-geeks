class Solution {
    public long[] productExceptSelf(int[] nums) {
        int n = nums.length;
        long[] mul = new long[n];
        long totalProduct = 1;
        int zeroCount = 0;

        for (int num : nums) {
            if (num != 0) {
                totalProduct *= num;
            }
            if (num == 0) {
                zeroCount++;
            }
            if (zeroCount > 1) {
                break;
            }
        }

        if (zeroCount > 1) {
            for (int i = 0; i < n; i++) {
                mul[i] = 0;
            }
            return mul;
        }

        if (zeroCount == 1) {
            for (int i = 0; i < n; i++) {
                if (nums[i] == 0) {
                    mul[i] = totalProduct;
                } else {
                    mul[i] = 0;
                }
            }
            return mul;
        }

        for (int i = 0; i < n; i++) {
            mul[i] = totalProduct / nums[i];
        }

        return mul;
    }
}
