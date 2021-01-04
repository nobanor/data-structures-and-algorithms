package com.practice.string;

import java.util.HashMap;
import java.util.Map;

/*
    Given an arbitrary ransom note string and another string containing letters from all the magazines,
    write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

    Each letter in the magazine string can only be used once in your ransom note.

    Example 1:

    Input: ransomNote = "a", magazine = "b"
    Output: false
    Example 2:

    Input: ransomNote = "aa", magazine = "ab"
    Output: false
    Example 3:

    Input: ransomNote = "aa", magazine = "aab"
    Output: true

    Constraints:

    You may assume that both strings contain only lowercase letters.
* */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {

        //Create a map to keep the count of characters
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        //Loop through magazine and count characters, add them to the hash table
        for(char c : magazine.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //Loop through ransom note and deduct characters if there are any
        for(char c : ransomNote.toCharArray()){
            if(!map.containsKey(c) || map.get(c) <= 0){
                return false;
            }

            map.put(c, map.get(c) - 1);
        }
        return true;
    }
}
