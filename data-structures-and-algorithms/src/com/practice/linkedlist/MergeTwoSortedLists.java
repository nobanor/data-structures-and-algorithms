package com.practice.linkedlist;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2){

        ListNode prev = new ListNode(-1);
        ListNode curr = prev;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                curr.next = list1;
                list1 = list1.next;
            } else{
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        //If any of the lists reached null, we need to merge current.next to point to the right node
        curr.next = list1 == null ? list2 : list1;

        return prev.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists mtsl = new MergeTwoSortedLists();

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next = new ListNode(5);

        ListNode list2 = new ListNode(4);
        list1.next = new ListNode(6);
        list1.next = new ListNode(7);

        ListNode mergedList = mtsl.mergeTwoLists(list1, list2);
    }
}
