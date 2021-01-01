package com.practice.array;

/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []


Constraints:

0 <= nums.length <= 3000
-105 <= nums[i] <= 105
* */

import java.util.*;

public class ThreeSum {

    /*We can use three pointers for this problem, but first we need to sort the array
    * We also need to initialize final list of triplets as well as current triplet*/

    public List<List<Integer>> threeSum(int[] array){

        Arrays.sort(array);

        Set<List<Integer>> triplets = new HashSet<>();

        for(int left = 0; left < array.length - 2; left++){
            int mid = left + 1;
            int right = array.length - 1;

            while(mid < right){

                int sum = array[left] + array[mid] + array[right];
                if(sum < 0){
                    mid++;
                }else if(sum > 0){
                    right--;
                }else{
                    List<Integer> currentTriplet = Arrays.asList(array[left], array[mid], array[right]);
                    triplets.add(currentTriplet);
                    mid++;
                }
            }
        }
        return new ArrayList<>(triplets);
    }

    public static void main(String[] args) {
        int[] array = {-1,0,1,2,-1,-4};

        ThreeSum threeSum = new ThreeSum();

        List<List<Integer>> triplets = threeSum.threeSum(array);

        for(Object o : triplets){
            System.out.println(o);
        }
    }
}
