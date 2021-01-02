package com.practice.array;

public class RotateImage {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n/2; i++){
            for(int j = i; j < n - i - 1; j++){
                //Save the top
                int top = matrix[i][j];

                //move left to top
                matrix[i][j] = matrix[n -1 -j][i];

                //move bottom to left
                matrix[n - 1 - j][i] = matrix[n - i - 1][n - 1 - j];

                //move right to bottom
                matrix[n - i - 1][n - 1 - j] = matrix[j][n - i - 1];

                //move top to right
                matrix[j][n - i - 1] = top;
            }
        }
    }
}
