package com.practice.array;
/*
Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.


Constraints:

1 <= nums.length <= 3 * 104
0 <= nums[i] <= 105
* */
public class JumpGame {

    /*O(n) time space solution. We need to start from the end and keep track of last good index
    * Our formula is : if(i + nums[i] >= lastGoodIndexPosition)lastGoodIndexPosition = i;
    * that way at the end our last good index should be 0 as we iterate throughout our array*/
    public boolean canJump(int[] nums) {
        int lastGoodIndexPosition = nums.length - 1;

        for(int i = nums.length - 1; i >= 0; i--){
            if(i + nums[i] >= lastGoodIndexPosition){
                lastGoodIndexPosition = i;
            }
        }
        return lastGoodIndexPosition == 0;
    }

    public static void main(String[] args) {

        JumpGame jumpGame = new JumpGame();

        int[] nums = {1, 2, 0, 2, 0, 1};

        boolean canJump = jumpGame.canJump(nums);
        System.out.println(canJump);
    }
}
