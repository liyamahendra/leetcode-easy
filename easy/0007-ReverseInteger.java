/*

7. Reverse Integer - Easy

Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^(31 - 1)], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:
Input: x = 123
Output: 321

Example 2:
Input: x = -123
Output: -321

Example 3:
Input: x = 120
Output: 21

Example 4:
Input: x = 0
Output: 0

Constraints:

-2^31 <= x <= 2^(31 - 1)
*/

// Time Complexity: Linear - O(n) - O of N
// Space Complexity: Constant - O(1)

class Solution {
    public int reverse(int num) {
        int reversed = 0;
        while (num != 0) {
            int reminder = num % 10;
            
            // Greater than 7 Because (pow(2,31) - 1) is the highest limit of int and the last digit of this ((Math.pow(2,31) % 10) - 1) is 7. So, if the next number is greater than this, then we should return 0

            if (reversed > Integer.MAX_VALUE/10 || (reversed == Integer.MAX_VALUE / 10 && reminder > 7)) {
                return 0;
            }   

            // Lesser than -8 Because (pow(2,31) - 1) is the highest limit of int and the last digit of this (Math.pow(-2,31) % 10) is -8. So, if the next number is smaller than this, then we should return 0
            if (reversed < Integer.MIN_VALUE/10 || (reversed == Integer.MIN_VALUE / 10 && reminder < -8)) {
                return 0;
            }
            
            reversed = reversed * 10 + reminder;
            num /= 10;
        }
        return reversed;
    }
}
