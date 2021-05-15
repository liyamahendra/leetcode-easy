import java.util.HashMap;

/* 

1. Two Sum

Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to `target`.

You may assume that each input would have *exactly one solution*, and you may not use the same element twice.

You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]

Constraints:

2 <= nums.length <= 103
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
*/

// Bruteforce Solution:
// ====================
// No need to check if nums is null or not because
// it is given that exactly one solution exists for the given input
// Time Complexity: Quadratic - O(n^2) - O of N Square
// Space Complexity: Constant

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        boolean found = false;
        
        for(int i=0; i< nums.length - 1; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    found = true;
                    break;
                }
            }
            if(found) {
                break;
            }
        }
        return ans;
    }
}

// Optimal Solution:
// ==================
// Time Complexity: Linear - O(n) - O of N
// Space Complexity: O(n)

class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        
        for(int i=0; i< nums.length; i++) {
            map.put(nums[i], i);   
        }
        
        for(int i=0; i<nums.length; i++) {
            // the condition after '&&'' ensures that the same number (if it is twice the target)
            // is not considered again
            if(map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                ans[0] = i;
                ans[1] = map.get(target - nums[i]);
                break;
            }
        }
        
        return ans;
    }
}