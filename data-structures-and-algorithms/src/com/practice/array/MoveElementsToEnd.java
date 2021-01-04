package com.practice.array;

/*
    Given an array nums and number to move, move the given number to the end of the array\
    Do this in-place. You cannot create additional data structure

    Variations of this questions are to keep the relative order, for which the solution is provided in second function
    Input: nums = [0,1,0,3,12], toMove = 0
    Output: [1,3,12,0,0]
*
* */
public class MoveElementsToEnd {

    /*Two pointer approach: i at start of the array, j at end of the array
    * we move j if the number seen is toMove, otherwise if we see number at i, we swap it with index j
    * This approach does not preserve the order of the original input array*/
    public void moveToEnd1(int[] nums, int toMove){

        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            while (left < right && nums[right] == toMove) right--;
            if(nums[left] == toMove){
                swap(left, right, nums);
            }
            left++;
        }
    }

    /*Similar approach but here both pointers start at beginning
    * We increment j no matter what. If the number at j is not our toMove, we swap it with i and we increment i
    * This approach preserves the order of the original input array*/
    public void moveToEnd2(int[] nums, int toMove){

        for(int i = 0, j = 0; i < nums.length && j < nums.length; j++){
            if(nums[j] != toMove){
                swap(i,j,nums);
                i++;
            }
        }
    }

    private void swap(int i, int j, int[] nums){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        MoveElementsToEnd moveElementsToEnd = new MoveElementsToEnd();

        int[] nums = {2, 4, 5, 6, 7, 8, 4, 2, 1};

        moveElementsToEnd.moveToEnd1(nums, 4);

        for(int num : nums) System.out.print(num + ",");
    }
}
