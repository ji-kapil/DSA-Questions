/*
Question:
You are given two arrays of equal length. Your task is to pair elements from both arrays such that the 
sum of absolute differences between each pair is minimized.

In other words, for two arrays a[] and b[] of size n, find the minimum value of:
    |a[0] - b[0]| + |a[1] - b[1]| + ... + |a[n-1] - b[n-1]|

Example:
Input:
a = [4, 1, 8, 7]
b = [2, 3, 6, 5]

Output:
Min absolute value is : 6
*/


import java.util.*;

public class Absolute_Difference {
    public static void main(String[] args) {

        // Two integer arrays
        int[] a = {4, 1, 8, 7};
        int[] b = {2, 3, 6, 5};

        // Sort both arrays in ascending order
        Arrays.sort(a);
        Arrays.sort(b);

        // Variable to store the sum of absolute differences
        int minDiff = 0;

        // Loop through both arrays and calculate absolute difference of each pair
        for (int i = 0; i < a.length; i++) {
            minDiff += Math.abs(a[i] - b[i]);
        }

        // Print the minimum total absolute difference
        System.out.println("Min absolute value is : " + minDiff);
    }
}
