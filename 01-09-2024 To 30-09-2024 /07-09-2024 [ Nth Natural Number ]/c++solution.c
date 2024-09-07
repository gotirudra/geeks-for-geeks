class Solution {
  public:
   long long findNth(long long n)
    {
        long long base = 1, result = 0;
        while (n > 0)
        {
            result += (n % 9) * base;
            base *= 10;
            n /= 9;
        }
        return result;
    }
};
