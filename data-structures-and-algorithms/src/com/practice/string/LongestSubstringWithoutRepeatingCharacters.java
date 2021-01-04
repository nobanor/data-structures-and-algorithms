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


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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

    public int lengthOfLongestSubstringTwo(String str){
        if(str.length() == 0){
            return 0;
        }

        //Create a hash map that stores characters seen
        Map<Character, Integer> lastSeen = new HashMap<>();

        //Will hold the start and end index to get the substring
        int[] longest = {0, 1};
        int startIndex = 0;

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);

            //Check if character is already seen
            if(lastSeen.containsKey(c)){
                startIndex = Math.max(startIndex, lastSeen.get(c) + 1);
            }

            //Update longest if new substring is longer
            if(longest[1] - longest[0] < i + 1 - startIndex){
                longest = new int[] {startIndex, i + 1};
            }

            //Update
            lastSeen.put(c, i);
        }

        //Get the result string with appropriate range
        String result = str.substring(longest[0], longest[1]);
        int resultLength = result.length();

        return resultLength;
    }

    public static void main(String[] args) {

        LongestSubstringWithoutRepeatingCharacters lwd = new LongestSubstringWithoutRepeatingCharacters();

        String s = "ABBCABDEFDD";
        //CABDEF - length 6
        int lenghtOfLongedSbstr = lwd.lengthOfLongestSubstring(s);

        System.out.println(lenghtOfLongedSbstr);
    }
}
