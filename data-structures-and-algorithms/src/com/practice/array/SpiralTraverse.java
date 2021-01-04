package com.practice.array;

import java.util.ArrayList;
import java.util.List;

/*
    Given an m x n matrix, return all elements of the matrix in spiral order.

    Example 1:
    Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
    Output: [1,2,3,6,9,8,7,4,5]

    Example 2:
    Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
    Output: [1,2,3,4,8,12,11,10,9,5,6,7]
*/
public class SpiralTraverse {

    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0){
            return new ArrayList<Integer>();
        }

        //Declare new array that will hold expected result
        List<Integer> result = new ArrayList<Integer>();

        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;

        while(startRow <= endRow && startCol <=endCol){

            //First we loop to the right of the matrix
            //We start at first column and we go until end column while still being in first row
            for(int col = startCol; col <= endCol; col++){
                //In this loop we are adding values to our result list
                //We are adding values from first row and column that is currently in the loop
                result.add(matrix[startRow][col]);
            }

            //Second we loop down, starting at second row and going until last row.
            //The reason we start at second is because we already visited all of the first row
            for(int row = startRow + 1; row <= endRow; row++){
                result.add(matrix[row][endCol]);
            }

            //Third we loop to the left, starting at second to last column and going until first one
            //While looping we are still being in last row
            for(int col = endCol - 1; col >= startCol; col--){
                //Edge case: when we go inside this can cause issue and we need to catch it
                if(startRow == endRow) break;
                result.add(matrix[endRow][col]);
            }

            //Third we go up, we are going from second to last row until second row
            //We are doing this while still being in the first column
            //The reason we are going to the second row is because our matrix starts at first
            //row aka index 0
            for(int row = endRow - 1; row > startRow; row--){
                //Edge case
                if(startCol == endCol) break;
                result.add(matrix[row][startCol]);
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }

        return result;
    }
}
