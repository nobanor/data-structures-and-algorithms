package com.practice.string;
/*
Convert a non-negative integer num to its English words representation.

        Example 1:

        Input: num = 123
        Output: "One Hundred Twenty Three"
        Example 2:

        Input: num = 12345
        Output: "Twelve Thousand Three Hundred Forty Five"
        Example 3:

        Input: num = 1234567
        Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
        Example 4:

        Input: num = 1234567891
        Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
*/

public class IntegerToEnglish {

    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) return  "Zero";
        return help(num);
    }

    String help(int num) {
        String ret = "";
        if (num < 20) {
            ret = LESS_THAN_20[num];
        } else if (num < 100) {
            ret = TENS[num / 10] + " " + help(num % 10);
        } else if (num < 1000) {
            ret = help(num / 100) + " Hundred " + help(num % 100);
        } else if (num < 1000000) {
            ret = help(num / 1000) + " Thousand " + help(num % 1000);
        } else if (num < 1000000000) {
            ret = help(num / 1000000) + " Million " + help(num % 1000000);
        } else {
            ret = help(num / 1000000000) + " Billion " + help(num % 1000000000);
        }
        return ret.trim();
    }
}
