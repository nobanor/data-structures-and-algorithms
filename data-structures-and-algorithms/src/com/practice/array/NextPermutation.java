package com.practice.array;

/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
Example 4:

Input: nums = [1]
Output: [1]

1321
2113

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100
* */
public class NextPermutation {

    public void nextPermutation(int[] nums){
        //We need to start from the end and check for the next number
        int k = nums.length - 2;
        while(k >= 0 && nums[k] >= nums[k + 1]){
            k--;
        }

        //Replace k with next greatest suffix
        for(int l = nums.length - 1; l > k; --l){
            if(nums[l] > nums[k]){
                int tmp = nums[k];
                nums[k] = nums[l];
                nums[l] = tmp;
                break;
            }

            reverse(nums, k + 1, nums.length - 1);
        }
    }

    private void reverse(int[] nums, int start, int end) {
        while(start < end){
            int tmp = nums[end];
            nums[end] = nums[start];
            nums[start] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {

        NextPermutation nextPermutation = new NextPermutation();

        int[] nums = {1, 2, 3, 4};

        System.out.println("Number before permutation");
        for(int num : nums){
            System.out.print(num);
        }

        nextPermutation.nextPermutation(nums);
        System.out.println("");
        System.out.println("Number after permutation");
        for(int num : nums){
            System.out.print(num);
        }
    }
}
