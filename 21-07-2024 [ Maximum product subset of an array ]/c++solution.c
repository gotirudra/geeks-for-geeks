// User function Template for C++

class Solution {
public:
    long long int findMaxProduct(vector<int>& arr) {
        const int MOD = 1000000007;
        
        if (arr.size() == 1) {
            return arr[0] % MOD;
        }
        
        long long int max_neg = LLONG_MIN;
        int count_neg = 0, count_zero = 0;
        long long int product = 1;
        
        for (int num : arr) {
            if (num == 0) {
                count_zero++;
                continue;
            }
            if (num < 0) {
                count_neg++;
                max_neg = max(max_neg, (long long int)num);
            }
            product = (product * num) % MOD;
        }
        
        if (count_zero == arr.size()) {
            return 0;
        }
        
        if (count_neg % 2 != 0) {
            if (count_neg == 1 && count_zero > 0 && count_zero + count_neg == arr.size()) {
                return 0;
            }
            product = product / max_neg;
        }
        
        return (product + MOD) % MOD; // To handle negative products
    }
};

