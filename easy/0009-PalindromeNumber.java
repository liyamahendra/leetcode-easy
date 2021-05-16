/*
Given an integer x, return true if x is palindrome integer.

An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.

Example 1:
Input: x = 121
Output: true

Example 2:
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:
Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

Example 4:
Input: x = -101
Output: false
 

Constraints:
-2^31 <= x <= 2^31 - 1

*/


// All negative numbers are not palindrome.

// One Solution is to convert the number to a string 
// and then check if the string is palindrome.

// If the reverted number is same as the original number, 
// then the number is a palindrome.
// However, if the reversed number is larger than int.MAX
// we will hit integer overflow problem.

// Time Complexity: Logarithmic - O(log(n)) - O of Log N to the base 10
// Space Complexity: Constant - O(1) - O of 1

class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        
        int reversed = 0;
        // we need originalX because we are modifying x,
        // and at end of while loop, x will be zero
        int originalX = x; 
        
        while(x != 0) {
            int reminder = x % 10;
            reversed = (reversed * 10) + reminder;
            x /= 10;
        }
        
        return (originalX == reversed);
    }
}

// To avoid the overflow issue of the reverted number, what if we only revert half of the int number?

class Solution2 {
    public boolean isPalindrome(int x) {
        // As discussed above, when x < 0, x is not a palindrome.
        // Also if the last digit of the number is 0, in order to be a palindrome,
        // the first digit of the number also needs to be 0.
        // Only 0 satisfy this property.
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        
        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        
        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
        return x == revertedNumber || x == revertedNumber/10;
    }
}
