#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* smallestNumber(int s, int d) {
    // If the sum s is greater than the maximum possible sum with d digits, return "-1"
    if (s > 9 * d) {
        return strdup("-1");
    }

    // Allocate memory for the result string
    char* ans = (char*)malloc((d + 1) * sizeof(char));
    memset(ans, '0', d);
    ans[d] = '\0';

    // Traverse the digits from the most significant to the least significant
    for (int i = d - 1; i >= 0; i--) {
        // Find the maximum digit we can use for the current place
        for (int j = 9; j >= 0; j--) {
            // Check if the remaining sum after using j is valid
            if (i != 0) {
                if (s - j > 0) {
                    ans[i] = '0' + j;  // Set the digit in the result string
                    s -= j;            // Decrease the sum by the chosen digit
                    break;
                }
            } else {
                ans[i] = '0' + s;  // For the least significant digit, use the remaining sum
                s = 0;
                break;
            }
        }
    }
    return ans;
}

int main() {
    int s = 9, d = 2;
    char* result = smallestNumber(s, d);
    printf("Smallest number with sum %d and %d digits is: %s\n", s, d, result);
    free(result);

    s = 20, d = 3;
    result = smallestNumber(s, d);
    printf("Smallest number with sum %d and %d digits is: %s\n", s, d, result);
    free(result);

    s = 21, d = 2;
    result = smallestNumber(s, d);
    printf("Smallest number with sum %d and %d digits is: %s\n", s, d, result);
    free(result);

    return 0;
}
