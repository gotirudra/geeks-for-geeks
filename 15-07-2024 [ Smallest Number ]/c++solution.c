/*    "copy & past only code between lines (//----------//) for getting result"  */
/*    "use gdb compiler for getting output of whole code"      */

#include <iostream>
#include <string>

//-------------------------------------------------------------------------------------------------

std::string smallestNumber(int s, int d) {
    // Handle edge case where sum is 0
    if (s == 0) {
        if (d == 1) {
            return "0";
        }
        return "-1"; // If more than 1 digit, it's not possible
    }

    // If the sum s is greater than the maximum possible sum with d digits, return "-1"
    if (s > 9 * d) {
        return "-1";
    }

    std::string ans(d, '0');

    // Traverse the digits from the most significant to the least significant
    for (int i = d - 1; i >= 0; --i) {
        // Determine the digit to place at the current position
        int digit = std::min(9, s);
        ans[i] = '0' + digit;
        s -= digit;
    }

    // Adjust the result to ensure there are no leading zeros (if more than 1 digit)
    if (ans[0] == '0' && d > 1) {
        for (int i = 1; i < d; ++i) {
            if (ans[i] > '0') {
                ans[i]--;
                ans[0] = '1';
                break;
            }
        }
    }

    return ans;
}

//----------------------------------------------------------------------------------------------------

int main() {
    int s = 9;
    int d = 2;
    std::string result = smallestNumber(s, d);
    std::cout << "Smallest number with sum " << s << " and " << d << " digits is: " << result << std::endl;
    return 0;
}
