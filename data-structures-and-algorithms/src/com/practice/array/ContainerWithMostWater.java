package com.practice.array;

/*

https://leetcode.com/explore/interview/card/google/59/array-and-strings/3048/
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.

Notice that you may not slant the container.

Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1
Example 3:

Input: height = [4,3,2,1,4]
Output: 16
Example 4:

Input: height = [1,2,1]
Output: 2


Constraints:

n = height.length
2 <= n <= 3 * 104
0 <= height[i] <= 3 * 104
* */

public class ContainerWithMostWater {

    public int maxArea(int[] height){

        int first = 0;
        int last = height.length - 1;

        int max = 0;
        while(first < last){

            int difference = last - first; //difference between last and first indexes
            int minHeight = Math.min(height[first], height[last]); //Get the minimum between height at first index and height at last index
            max = Math.max(difference * minHeight, max); //difference * minimum height will give the current area, we need to compare it against max

            /*If height at first is smaller, increment first otherwise decrement last*/
            if(height[first] < height[last]){
                first++;
            }else{
                last--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();

        int[] height = {1,8,6,2,5,4,8,3,7};

        int maxArea = containerWithMostWater.maxArea(height);

        System.out.println(maxArea);
    }
}
