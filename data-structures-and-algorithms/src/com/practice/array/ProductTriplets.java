package com.practice.array;

import java.util.*;

/*
Given an array of distinct integers(considering only positive numbers) and a number ‘m’, find the number of triplets with product equal to ‘m’.
Examples:

Input : arr[] = { 1, 4, 6, 2, 3, 8}
            m = 24
Output : 3
{1, 4, 6} {1, 3, 8} {4, 2, 3}

Input : arr[] = { 0, 4, 6, 2, 3, 8}
            m = 18
Output : 0
* */
public class ProductTriplets {

    /*
    * A brute force solution would have 3 nested for loops, checking for all the numbers, this would have O(n^3)
    * A more optimal solution would be to sort the array and have 3 pointers, start, mid and end
    * If we find a product triplet we add it our our triplets array, in case of count triplest we can just keep the count
    * The optimal solution to this approach would have O(n^2) time complexity and O(n) space complexity
    */

    public static int countTriplets(int[] nums, int target){

        int count = 0;

        if(nums == null || nums.length == 0){
            return count;
        }
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            int start = i;
            int mid = i + 1;
            int end = nums.length - 1;

            while(mid < end){
                int currentProduct = nums[start] * nums[mid] * nums[end];

                if(currentProduct == target){
                    count++;
                    mid++;
                    end--;
                } else if(currentProduct < target){
                    mid++;
                } else{
                    end--;
                }
            }
        }
        return count;
    }

    public static List<List<Integer>> getTriplets(int[] nums, int target){

        Set<List<Integer>> triplets = new HashSet<>();

        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            int start = i;
            int mid = i + 1;
            int end = nums.length - 1;

            while(mid < end){
                int currentProduct = nums[start] * nums[mid] * nums[end];

                if(currentProduct == target){
                    List<Integer> currentTriplet = Arrays.asList(nums[start], nums[mid], nums[end]);
                    triplets.add(currentTriplet);
                    mid++;
                    end--;
                } else if(currentProduct < target){
                    mid++;
                } else{
                    end--;
                }
            }
        }
        return new ArrayList<>(triplets);
    }

    public static void main(String[] args) {
        //Test functions here
    }
}
