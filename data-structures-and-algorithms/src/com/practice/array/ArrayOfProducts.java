package com.practice.array;

/*
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
*/
public class ArrayOfProducts {

    /*Brute force solution would be to have a double for loop, and every time i == j, we skip number, so we don't multiply.
    * This type of solution would have O(n^2) time complexity
    * */
    public int[] productExceptItselfBruteForce(int[] nums){

        if(nums.length == 0 || nums == null){
            return new int[]{};
        }

        int[] result = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            int currentProduct = 1;
            for(int j = 0; j < nums.length; j++){
                if(i == j) continue;
                currentProduct *= nums[j];
            }
            result[i] = currentProduct;
        }
        return result;
    }

    /*We can accomplish linear time complexity by having two passes
    * we would first start from left and go to right, multipyling elemments wit
    * The we would go from right to left
    * This solution would have O(n) time complexity. It would actually be O(2n) but we are dropping constants so just O(n)
    * */
    public int[] productExceptItself(int[] nums){
        if(nums.length == 0 || nums == null){
            return new int[]{};
        }

        int[] result = new int[nums.length];

        int leftProduct = 1;
        int rightProduct = 1;

        for(int i = 0; i < nums.length; i++){
            result[i] = leftProduct;
            leftProduct *= nums[i];
        }

        for(int i = nums.length - 1; i >= 0; i--){
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return result;

    }

    public static void main(String[] args) {

        ArrayOfProducts arrayOfProducts = new ArrayOfProducts();

        int[] nums = {1, 2, 3, 4};

        int[] productsArray1 = arrayOfProducts.productExceptItselfBruteForce(nums);
        int[] productsArray2 = arrayOfProducts.productExceptItself(nums);

        for (int num : productsArray2){
            System.out.print(num + ",");
        }


    }
}
