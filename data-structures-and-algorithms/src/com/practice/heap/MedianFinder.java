package com.practice.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/*
* Problem: https://leetcode.com/problems/find-median-from-data-stream/
*
* */
public class MedianFinder {

    private PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());//reverse order to make it max heap
    private PriorityQueue<Integer> large = new PriorityQueue<>();//min heap
    private boolean even = true;

    public double findMedian() {

        if (even)//If numbers are even, return median of middle two
            return (small.peek() + large.peek()) / 2.0;
        else //else return middle element which will be at the top of small heap
            return small.peek();
    }

    public void addNum(int num) {

        if (even) {
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }

        even = !even;
    }

    public static void main(String[] args) {

        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        medianFinder.addNum(4);
        medianFinder.addNum(5);
        medianFinder.addNum(19);
        medianFinder.addNum(11);
        medianFinder.addNum(40);

        System.out.println(medianFinder.findMedian());

    }
}
