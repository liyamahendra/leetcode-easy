/* 

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 
Example 3:
Input: strs = ["leets", "leetcode", "leet", "leeds"]
Output: "lee"

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lower-case English letters.

*/

// Start with the first string in the array
// 

class Solution {
    // Here we say Prefix - meaning the starting part of the string, always.
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) 
            return "";
        
        // Take the first string as prefix
        String prefix = strs[0];
        
        // Start from the second string 
        for (int i = 1; i < strs.length; i++) {
            
            /*
            indexOf - Returns an int value, representing the index of the first occurrence of the character in the string, or -1 if it never occurs 

            Eg: 
            String myStr = "Hello planet earth, you are a great planet.";
            System.out.println(myStr.indexOf("planet")); // will output 6
            */
            while (strs[i].indexOf(prefix) != 0) {
                // Continuously reduce the string size by removing the last character
                // until the prefix is a part of the string (determined by indexOf method)
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }    
            
        }
        return prefix;
    }
}

// Time complexity : O(S) where S is the sum of all characters in all strings.
// Space complexity : O(1) - We only used constant extra space. 

// Approach 2: Vertical scanning i.e. We compare characters from top to bottom on the same column (same character index of the strings) before moving on to the next column.

class Solution2 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) 
            return "";
        
        // Take the first string as prefix
        String prefix = "";
        boolean found = false;
        
        for(int i=0; i<strs[0].length(); i++) {
          prefix = strs[0].substring(0, i+1);

          for(int j=0; j<strs.length; j++) {
            if(strs[j].indexOf(prefix) != 0) {
              found = true;
              prefix = prefix.substring(0, prefix.length() - 1); // because the recently added character is not matching
              break;
            } 
          }   

          if(found) {
            break;
          }
        }
        
        return prefix;
    }
}

// Time complexity : O(S) where S is the sum of all characters in all strings.
// Space complexity : O(1) - We only used constant extra space. 