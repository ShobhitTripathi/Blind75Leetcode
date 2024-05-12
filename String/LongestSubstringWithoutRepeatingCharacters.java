/*
 Longest Substring Without Repeating Characters

Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0, start = 0, end = 0, currentLength = 0;
        if (s.length() == 1 || s.length() == 0) {
            return s.length();
        }

        while (end < s.length()) {
            currentLength = end - start;
            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
            if (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start));
                start++;
            } else {
                set.add(s.charAt(end));
                end++;
            }
        }

        currentLength = end - start;
        if (currentLength > maxLength) {
                maxLength = currentLength;
        }
        return maxLength;
    }
}
