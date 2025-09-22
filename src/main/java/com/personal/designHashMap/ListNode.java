package com.personal.designHashMap;

//to control data, if some elements are in the same bucket
//works like a linked list
public class ListNode {

    int key;
    int value;
    ListNode next;

    public ListNode(int key, int value, ListNode next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
