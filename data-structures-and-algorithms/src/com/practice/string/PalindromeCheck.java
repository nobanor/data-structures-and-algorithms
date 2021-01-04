package com.practice.string;

/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false

Constraints:

s consists only of printable ASCII characters.
* */
public class PalindromeCheck {

    public static boolean isPalindrome(String str){

        int leftIndex = 0;
        int rightIndex = str.length() - 1;

        while(leftIndex < rightIndex){

            /*If we encounter spaces or invalid characters, we skip over them*/
            while(leftIndex < rightIndex && !Character.isLetterOrDigit(str.charAt(leftIndex))){
                leftIndex++;
            }

            while (leftIndex < rightIndex && !Character.isLetterOrDigit(str.charAt(rightIndex))){
                rightIndex--;
            }

            if(Character.toLowerCase(str.charAt(leftIndex)) != Character.toLowerCase(str.charAt(rightIndex))) return false;

            leftIndex++;
            rightIndex--;
        }
        return true;
    }
}
