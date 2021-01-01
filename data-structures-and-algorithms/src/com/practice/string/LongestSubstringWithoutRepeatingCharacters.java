package com.practice.string;

/*
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
Example 4:

Input: s = ""
Output: 0
* */


import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s){
        if(s.length() == 0){
            return 0;
        }

        int slowPointer = 0, fastPointer = 0, max = 0;

        Set<Character> set = new HashSet<>();

        while(fastPointer < s.length()){
            /*If set doesn't contain char at fast pointer, we add it to the set, and increment fast pointer */
            if(!set.contains(s.charAt(fastPointer))){
                set.add(s.charAt(fastPointer));
                fastPointer++;
                max = Math.max(max, set.size());
            }else{
                /*If contains char at fast pointer, we need to remove char at first pointer to keep our substring unique,
                  and we incrment slow pointer */
                set.remove(s.charAt(slowPointer));
                slowPointer++;
            }
        }
        //We return the maximum length of our subset
        return max;
    }

    public static void main(String[] args) {

        LongestSubstringWithoutRepeatingCharacters lwd = new LongestSubstringWithoutRepeatingCharacters();

        String s = "ABBCABDEFDD";
        //CABDEF - length 6
        int lenghtOfLongedSbstr = lwd.lengthOfLongestSubstring(s);

        System.out.println(lenghtOfLongedSbstr);
    }
}
