package com.practice.string;

/*
    Given a string s, return the longest palindromic substring in s.



    Example 1:

    Input: s = "babad"
    Output: "bab"
    Note: "aba" is also a valid answer.
    Example 2:

    Input: s = "cbbd"
    Output: "bb"
    Example 3:

    Input: s = "a"
    Output: "a"
    Example 4:

    Input: s = "ac"
    Output: "a"
* */
public class LongestPalindromicSubstring {

    /*
        Brute force solution would be to have a double for loop and as we iterate through our array, check for palindrome
            This solution is however not the most optimal one and will result in
            O(n^3)
        Optimal solution would have one loop and we would create an expand function.
        We would need to make sure that we are making two calls to the funcions since we could have an even or odd palindrome

    */
    int resultStart;
    int resultLength;

    public String longestPalindrome(String s){
        int len = s.length();
        if(len < 2){
            return s;
        }

        for(int start = 0; start < len - 1; start++){
            expandRange(s, start, start);
            expandRange(s, start, start + 1);
        }
        return s.substring(resultStart, resultStart + resultLength);
    }

    private void expandRange(String s, int start, int end) {

        //While this condition is true, we keep expanding the string
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }

        if(resultLength < end - start - 1){
            resultStart = start + 1;
            resultLength = end - start - 1;
        }
    }


}
